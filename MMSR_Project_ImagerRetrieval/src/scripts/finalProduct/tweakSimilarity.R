file <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/finalProduct/retrievedImages.csv",
         header = FALSE)

monumentList <- list.dirs(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/img", 
                          full.names=FALSE, recursive=FALSE)

finalList <- NULL
for (monument in monumentList) {
  imgVisMonument <- imgVisList[imgVisList[1]==monument,]
  
  if (nrow(imgVisMonument) > 0) {
    score <- NULL
    scoreInterval <- 1/(nrow(imgVisMonument)+1)
    for (i in 1:nrow(imgVisMonument)) {
      score[i] <- 1-i*scoreInterval
    }
    finalList <- rbind(finalList, cbind(imgVisMonument[,1], imgVisMonument[,2], score))
  }
}

write.table(finalList, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/finalProduct/final_onlyImg.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)