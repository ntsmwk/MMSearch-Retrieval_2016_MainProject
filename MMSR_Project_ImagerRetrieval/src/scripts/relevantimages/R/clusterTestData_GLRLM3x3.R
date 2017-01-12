
files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/img", 
                    pattern="*GLRLM3x3.csv", full.names=T, recursive=FALSE)

centroids <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_GLRLM3x3.csv", header=FALSE)
result <- NULL
for (file in files) {
  csvfile <- read.csv(file, header=FALSE)
  
  normalized <- t(apply(csvfile[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  for (l in seq(nrow(normalized))) {
    distances <- NULL
    for (c in seq(nrow(centroids))) { 
      distances <- rbind(distances, cbind(centroids[c,1], dist(rbind(normalized[l,], centroids[c,-1]), method="euclidean")))
    }
    result <- rbind(result, c(csvfile[l, 1], distances[which.min(distances[,2]),]))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_GLRLM3x3.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)