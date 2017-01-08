library(plyr)
library(testit)

distanceFiles <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages", 
                    pattern="distances*", full.names=TRUE, recursive=FALSE)

dirs <- list.dirs(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/img", 
                  full.names=FALSE, recursive=FALSE)

correctlyClustered <- NULL
imgOccUnsorted <- NULL

warn <- NULL

for (monument in dirs) {
  imagesPath = paste0("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/img/", monument)
  images <- list.files(path=imagesPath, 
                       pattern=".", full.names=FALSE, recursive=FALSE)
  for(image in images) {
    imageName <- substr(image,1,regexpr("\\.", image)-1)
    
    for (file in distanceFiles) {
      distances <- read.csv(file, header=FALSE)
      
      for (name in distances[,1]) {
        if (name == imageName) {
          line <- c(distances[distances[1]==name,])
          
          tt <- tryCatch(
            if (line[2]==monument) {
              correctlyClustered <- rbind(correctlyClustered, c(monument, line[3], imageName, line[4]))
            },
            error=function(e) e, warning=function(w) w)
          if(is(tt,"warning")) print(paste(monument, line[1]))
        }
      }
    }
    numOcc <- length(correctlyClustered[correctlyClustered[,3]==imageName,3])
    if (numOcc > 0L) {
      imgDist <- correctlyClustered[correctlyClustered[,3]==imageName,4]
      meanDist <- mean(unlist(imgDist))
      if (length(correctlyClustered[correctlyClustered[,3]==imageName,2]) > 1) {
        cluster <- sapply(correctlyClustered[correctlyClustered[,3]==imageName,2], function (x) x[1])
      } else {
        cluster <- correctlyClustered[correctlyClustered[,3]==imageName,2]
      }
        imgOccUnsorted <- rbind(imgOccUnsorted, c(monument, as.integer(cluster[1]), imageName, numOcc, meanDist))
        imgOccSorted <- as.data.frame(imgOccUnsorted)
        imgOccSorted <- arrange(imgOccSorted, desc(imgOccSorted[4]), imgOccSorted[5])
    }
  }
}

write.table(imgOccSorted, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/retrievedImages.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)
