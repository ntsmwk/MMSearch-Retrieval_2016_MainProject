file <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/finalProduct/combinedList.csv",
         header = FALSE)

monumentList <- list.dirs(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/img", 
                          full.names=FALSE, recursive=FALSE)

finalList <- NULL
for (monument in monumentList) {
  monList <- file[file[1]==monument,2]
  monList <- unique(monList)
  
  if (length(monList) > 0) {
    score <- NULL
    scoreInterval <- 1/(length(monList)+1)
    for (i in 1:length(monList)) {
      score[i] <- 1-i*scoreInterval
    }
    finalList <- rbind(finalList, cbind(monument, monList, score))
  }
}


write.table(finalList, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/finalProduct/final.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)