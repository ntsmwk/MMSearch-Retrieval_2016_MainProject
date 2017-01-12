library(plyr)
library(testit)

distanceFiles <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages", 
                    pattern="distances*", full.names=TRUE, recursive=FALSE)

dirs <- list.dirs(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/img", 
                  full.names=FALSE, recursive=FALSE)

correctlyClustered <- NULL
imgOccUnsorted <- NULL
imgOccSorted <- NULL

warn <- NULL

for (monument in dirs) {
  imagesPath = paste0("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/img/", monument)
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
              correctlyClustered <- rbind(correctlyClustered, c(monument, imageName, line[3]))
            },
            error=function(e) e, warning=function(w) w)
          if(is(tt,"warning")) print(paste(monument, line[1]))
        }
      }
      #line <- distances[distances[,1]==imageName,]
    
    }
    numOcc <- length(correctlyClustered[correctlyClustered[,2]==imageName,3])
    if (numOcc > 0L) {
      imgDist <- correctlyClustered[correctlyClustered[,2]==imageName,3]
      meanDist <- mean(unlist(imgDist))
      imgOccUnsorted <- rbind(imgOccUnsorted, c(monument, imageName, numOcc, meanDist))
      imgOccSorted <- as.data.frame(imgOccUnsorted)
      imgOccSorted <- arrange(imgOccSorted, desc(imgOccSorted[3]), imgOccSorted[4])
    }
  }
}


write.table(imgOccSorted, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/retrievedImages_second.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)
