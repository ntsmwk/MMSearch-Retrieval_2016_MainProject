library(testit)

imgVisList <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/finalProduct/retrievedImages.csv",
                       header = FALSE)
monumentList <- list.dirs(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/img", 
                          full.names=FALSE, recursive=FALSE)

finalList <- NULL
for (monument in monumentList) {
  imgVisMonument <- imgVisList[imgVisList[1]==monument,]
  if (nrow(imgVisMonument) > 0) {
    imgVisMonument <- unique(imgVisMonument)
    imgVisMonument <- cbind(imgVisMonument[2],-1)
  }
  
  txtPath <- paste0("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/finalProduct/Rank/Testset/", monument, ".txt")
  cols <- c('character', 'numeric')
  imgTxtMonument <- read.csv(txtPath, header = FALSE, sep=" ", colClasses=cols)
  imgTxtMonument <- unique(imgTxtMonument)

  temp <- vector()
  for (i in 1:nrow(imgTxtMonument)) {
    temp[i] <- substr(imgTxtMonument[i,1],1,regexpr("\\.", imgTxtMonument[i,1])-1)
  }
  imgTxtMonument <- cbind(temp, imgTxtMonument[2])
  
  colNames <- c("V1", "V2")
  names(imgTxtMonument) <- colNames
  names(imgVisMonument) <- colNames
  
  if (is.numeric(imgTxtMonument[,1])) {
    imgTxtMonument[,1] <- as.character(imgTxtMonument[,1])
  }
  
  if (is.numeric(imgVisMonument[,1])) {
    imgVisMonument[,1] <- as.character(imgVisMonument[,1])
  }
  
  # if visual list is empty, just take the textual list and move on
  if (nrow(imgVisMonument) == 0) {
    finalList <- rbind(finalList, cbind(monument, imgTxtMonument[1:nrow(imgTxtMonument),]))
    next
  }
  
  iVis <- 1
  iTxt <- 1
  for (iTxt in 1:nrow(imgTxtMonument)) {
     if (iVis <= nrow(imgVisMonument)
        && iTxt <= nrow(imgTxtMonument)) {
      # do reißverschluss
      if (!imgVisMonument[iVis,1] %in% finalList[,2]) {
        finalList <- rbind(finalList, cbind(monument, imgVisMonument[iVis,]))
      
      } else if (nrow(imgVisMonument) == 0) {
        break
      
      } else {  
        while (imgVisMonument[iVis,1] %in% finalList) {
          iVis <- iVis + 1
        }
        finalList <- rbind(finalList, cbind(monument, imgVisMonument[iVis,]))
      }
      
      if (!imgTxtMonument[iTxt,1] %in% finalList[,2]) {
        finalList <- rbind(finalList, cbind(monument, imgTxtMonument[iTxt,]))
      
      } else if (nrow(imgTxtMonument) == 0) {
        break
        
      }else {
        while (imgTxtMonument[iTxt,1] %in% finalList[,2]) {
          iTxt <- iTxt + 1
        }
        finalList <- rbind(finalList, cbind(monument, imgTxtMonument[iTxt,]))
      }
      
      iTxt <- iTxt + 1
      iVis <- iVis + 1
    } else {
      # add rest of files
      if (iVis > nrow(imgVisMonument)) {
        finalList <- rbind(finalList, cbind(monument, imgTxtMonument[iTxt:nrow(imgTxtMonument),]))
      } else {
        finalList <- rbind(finalList, cbind(monument, imgVisMonument[iVis:nrow(imgVisMonument),]))
      }
      
      break
    }
  }
}

write.table(finalList, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/finalProduct/combinedList.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)