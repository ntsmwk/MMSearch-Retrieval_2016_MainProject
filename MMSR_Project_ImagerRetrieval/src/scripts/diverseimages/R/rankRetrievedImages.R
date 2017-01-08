library(plyr)

retrievedImages <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/retrievedImages.csv", header=FALSE)

dirs <- list.dirs(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/img", 
                  full.names=FALSE, recursive=FALSE)

used <- vector()

retrievedImages <- arrange(retrievedImages, desc(retrievedImages[4]), retrievedImages[5])

rankedFile <- NULL
for (monument in dirs) {
  path <- paste0("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/gt/dGT/", monument, " dGT.txt")
  clusters <- read.csv(path, header=FALSE)
  monumentImgs <- cbind(retrievedImages[retrievedImages[]==monument,2], retrievedImages[retrievedImages[]==monument,3])
  
  used <- numeric(nrow(clusters))
  
  for (img in monumentImgs[,2]) {
    img <- rbind(monumentImgs[monumentImgs[,2]==img])
    currentCounter <- min(used)
    
    index <- img[1]
    if (used[index] == currentCounter) {
      rankedFile <- rbind(rankedFile, c(monument, img[2]))
      used[img[1]] <- currentCounter + 1
    }
  }
}

write.table(rankedFile, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/rankedImages.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

