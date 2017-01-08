
files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img", 
                    pattern="*CM.csv", full.names=T, recursive=FALSE)

centroids <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_CM.csv", header=FALSE)
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
    centroids[which.min(distances[,2]),-1] <- colMeans(rbind(csvfile[l,-1], centroids[which.min(distances[,2]), -1]))
    centroids[which.min(distances[,2]),-1] <- t(apply(centroids[which.min(distances[,2]),-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_CM_updated.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# ---------------------------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img", 
                    pattern="*CM3x3.csv", full.names=T, recursive=FALSE)

centroids <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_CM3x3.csv", header=FALSE)
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
    centroids[which.min(distances[,2]),-1] <- colMeans(rbind(csvfile[l,-1], centroids[which.min(distances[,2]), -1]))
    centroids[which.min(distances[,2]),-1] <- t(apply(centroids[which.min(distances[,2]),-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_CM3x3_updated.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# --------------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img", 
                    pattern="*CN.csv", full.names=T, recursive=FALSE)

centroids <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_CN.csv", header=FALSE)
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
    centroids[which.min(distances[,2]),-1] <- colMeans(rbind(csvfile[l,-1], centroids[which.min(distances[,2]), -1]))
    centroids[which.min(distances[,2]),-1] <- t(apply(centroids[which.min(distances[,2]),-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_CN_updated.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# --------
rm(list=ls())


files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img", 
                    pattern="*CN3x3.csv", full.names=T, recursive=FALSE)

centroids <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_CN3x3.csv", header=FALSE)
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
    centroids[which.min(distances[,2]),-1] <- colMeans(rbind(csvfile[l,-1], centroids[which.min(distances[,2]), -1]))
    centroids[which.min(distances[,2]),-1] <- t(apply(centroids[which.min(distances[,2]),-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_CN3x3_updated.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# ------------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img", 
                    pattern="*CSD.csv", full.names=T, recursive=FALSE)

centroids <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_CSD.csv", header=FALSE)
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
    centroids[which.min(distances[,2]),-1] <- colMeans(rbind(csvfile[l,-1], centroids[which.min(distances[,2]), -1]))
    centroids[which.min(distances[,2]),-1] <- t(apply(centroids[which.min(distances[,2]),-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_CSD_updated.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# --------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img", 
                    pattern="*GLRLM.csv", full.names=T, recursive=FALSE)

centroids <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_GLRLM.csv", header=FALSE)
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
    centroids[which.min(distances[,2]),-1] <- colMeans(rbind(csvfile[l,-1], centroids[which.min(distances[,2]), -1]))
    centroids[which.min(distances[,2]),-1] <- t(apply(centroids[which.min(distances[,2]),-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_GLRLM_updated.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# --------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img", 
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
    centroids[which.min(distances[,2]),-1] <- colMeans(rbind(csvfile[l,-1], centroids[which.min(distances[,2]), -1]))
    centroids[which.min(distances[,2]),-1] <- t(apply(centroids[which.min(distances[,2]),-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_GLRLM3x3_updated.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# --------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img", 
                    pattern="*HOG.csv", full.names=T, recursive=FALSE)

centroids <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_HOG.csv", header=FALSE)
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
    centroids[which.min(distances[,2]),-1] <- colMeans(rbind(csvfile[l,-1], centroids[which.min(distances[,2]), -1]))
    centroids[which.min(distances[,2]),-1] <- t(apply(centroids[which.min(distances[,2]),-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_HOG_updated.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# --------
rm(list=ls())


files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img", 
                    pattern="*LBP.csv", full.names=T, recursive=FALSE)

centroids <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_LBP.csv", header=FALSE)
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
    centroids[which.min(distances[,2]),-1] <- colMeans(rbind(csvfile[l,-1], centroids[which.min(distances[,2]), -1]))
    centroids[which.min(distances[,2]),-1] <- t(apply(centroids[which.min(distances[,2]),-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_LBP_updated.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# --------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img", 
                    pattern="*LBP3x3.csv", full.names=T, recursive=FALSE)

centroids <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_LBP3x3.csv", header=FALSE)
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
    centroids[which.min(distances[,2]),-1] <- colMeans(rbind(csvfile[l,-1], centroids[which.min(distances[,2]), -1]))
    centroids[which.min(distances[,2]),-1] <- t(apply(centroids[which.min(distances[,2]),-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  }
}

write.table(result, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/distances_LBP3x3_updated.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)
