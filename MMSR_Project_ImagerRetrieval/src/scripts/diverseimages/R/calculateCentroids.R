clusterGT <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/gt/dGT", 
                  pattern="* dclusterGT.txt", full.names=TRUE, recursive=FALSE)
dGT <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/gt/dGT", 
                    pattern="* dGT.txt", full.names=TRUE, recursive=FALSE)

monumentNames <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/gt/dGT", 
                            pattern="* dGT.txt", full.names=FALSE, recursive=FALSE)

relevantImages <- read.csv("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/retrievedImages.csv", header=FALSE)

masterfileCM <- NULL
masterfileCM3x3 <- NULL
masterfileCN <- NULL
masterfileCN3x3 <- NULL
masterfileCSD <- NULL
masterfileGLRLM <- NULL
masterfileGLRLM3x3 <- NULL
masterfileHOG <- NULL
masterfileLBP <- NULL
masterfileLBP3x3 <- NULL

# work through files with cluster-associations for each image
for (file in dGT) {
  gtClusteredImgs <- read.csv(file, header=FALSE)
  
  # get name of current monument
  startIndex <- nchar("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/gt/dGT/")
  monumentName <- trimws(substring(file, first = startIndex+1, last = gregexpr(pattern =' dGT.txt',file)))
  
  # build set of already retrieved images for this monument
  subsetOfImgs <- relevantImages[relevantImages[1]==monumentName,]
  
  # get get cluster file to current monument
  clusterFile <- substring(file, first = 1, last = gregexpr(pattern =' dGT.txt',file))
  clusterFile <- paste0(clusterFile, "dclusterGT.txt")
  clusterFile <- read.csv(clusterFile, header=FALSE)
  
  # read datafiles
  path <- "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/img/"
  dataCM <- read.csv(paste0(path, monumentName, " CM.csv"), header=FALSE)
  dataCM3x3 <- read.csv(paste0(path, monumentName, " CM3x3.csv"), header=FALSE)
  dataCN <- read.csv(paste0(path, monumentName, " CN.csv"), header=FALSE)
  dataCN3x3 <- read.csv(paste0(path, monumentName, " CN3x3.csv"), header=FALSE)
  dataCSD <- read.csv(paste0(path, monumentName, " CSD.csv"), header=FALSE)
  dataGLRLM <- read.csv(paste0(path, monumentName, " GLRLM.csv"), header=FALSE)
  dataGLRLM3x3 <- read.csv(paste0(path, monumentName, " GLRLM3x3.csv"), header=FALSE)
  dataHOG <- read.csv(paste0(path, monumentName, " HOG.csv"), header=FALSE)
  dataLBP <- read.csv(paste0(path, monumentName, " LBP.csv"), header=FALSE)
  dataLBP3x3 <- read.csv(paste0(path, monumentName, " LBP3x3.csv"), header=FALSE)
    
  # work through the lines of the cluster file
  for (clusterLine in clusterFile[,1]) {
    # get images of this cluster
    imgsOfCluster <- gtClusteredImgs[gtClusteredImgs[2]==clusterLine,]
    
    # compare with retrieved images
    correctlyClustered <- NULL
    for (img in imgsOfCluster[,1]) {
      if (is.element(img, subsetOfImgs$V2)) {
        correctlyClustered <- rbind(correctlyClustered, img)
      }
    }
    
    # --- retrieve data for each image ---
    # find data for each image, normalize it and calculate centroid
    # CM
    if (length(correctlyClustered) == 0) {
      filteredData <- subset(dataCM, is.element(V1,as.vector(imgsOfCluster[,1])))
    } else {
      filteredData <- subset(dataCM, is.element(V1,as.vector(correctlyClustered)))
    }
    normalized <- t(apply(filteredData[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
    centroidCM <- colMeans(normalized)
    masterfileCM <- rbind(masterfileCM, c(monumentName, clusterLine, centroidCM))
    
    # CM3x3
    if (length(correctlyClustered) == 0) {
      filteredData <- subset(dataCM3x3, is.element(V1,as.vector(imgsOfCluster[,1])))
    } else {
      filteredData <- subset(dataCM3x3, is.element(V1,as.vector(correctlyClustered)))
    }
    normalized <- t(apply(filteredData[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
    centroidCM3x3 <- colMeans(normalized)
    masterfileCM3x3 <- rbind(masterfileCM3x3, c(monumentName, clusterLine, centroidCM3x3))
    
    # CN
    if (length(correctlyClustered) == 0) {
      filteredData <- subset(dataCN, is.element(V1,as.vector(imgsOfCluster[,1])))
    } else {
      filteredData <- subset(dataCN, is.element(V1,as.vector(correctlyClustered)))
    }
    normalized <- t(apply(filteredData[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
    centroidCN <- colMeans(normalized)
    masterfileCN <- rbind(masterfileCN, c(monumentName, clusterLine, centroidCN))
    
    # CN3x3
    if (length(correctlyClustered) == 0) {
      filteredData <- subset(dataCN3x3, is.element(V1,as.vector(imgsOfCluster[,1])))
    } else {
      filteredData <- subset(dataCN3x3, is.element(V1,as.vector(correctlyClustered)))
    }
    normalized <- t(apply(filteredData[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
    centroidCN3x3 <- colMeans(normalized)
    masterfileCN3x3 <- rbind(masterfileCN3x3, c(monumentName, clusterLine, centroidCN3x3))
    
    # CSD
    if (length(correctlyClustered) == 0) {
      filteredData <- subset(dataCSD, is.element(V1,as.vector(imgsOfCluster[,1])))
    } else {
      filteredData <- subset(dataCSD, is.element(V1,as.vector(correctlyClustered)))
    }
    normalized <- t(apply(filteredData[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
    centroidCSD <- colMeans(normalized)
    masterfileCSD <- rbind(masterfileCSD, c(monumentName, clusterLine, centroidCSD))
    
    # GLRLM
    if (length(correctlyClustered) == 0) {
      filteredData <- subset(dataGLRLM, is.element(V1,as.vector(imgsOfCluster[,1])))
    } else {
      filteredData <- subset(dataGLRLM, is.element(V1,as.vector(correctlyClustered)))
    }
    normalized <- t(apply(filteredData[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
    centroidGLRLM <- colMeans(normalized)
    masterfileGLRLM <- rbind(masterfileGLRLM, c(monumentName, clusterLine, centroidGLRLM))
    
    # GLRLM3x3
    if (length(correctlyClustered) == 0) {
      filteredData <- subset(dataGLRLM3x3, is.element(V1,as.vector(imgsOfCluster[,1])))
    } else {
      filteredData <- subset(dataGLRLM3x3, is.element(V1,as.vector(correctlyClustered)))
    }
    normalized <- t(apply(filteredData[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
    centroidGLRLM3x3 <- colMeans(normalized)
    masterfileGLRLM3x3 <- rbind(masterfileGLRLM3x3, c(monumentName, clusterLine, centroidGLRLM3x3))
    
    # HOG
    if (length(correctlyClustered) == 0) {
      filteredData <- subset(dataHOG, is.element(V1,as.vector(imgsOfCluster[,1])))
    } else {
      filteredData <- subset(dataHOG, is.element(V1,as.vector(correctlyClustered)))
    }
    normalized <- t(apply(filteredData[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
    centroidHOG <- colMeans(normalized)
    masterfileHOG <- rbind(masterfileHOG, c(monumentName, clusterLine, centroidHOG))
    
    # LBP
    if (length(correctlyClustered) == 0) {
      filteredData <- subset(dataLBP, is.element(V1,as.vector(imgsOfCluster[,1])))
    } else {
      filteredData <- subset(dataLBP, is.element(V1,as.vector(correctlyClustered)))
    }
    normalized <- t(apply(filteredData[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
    centroidLBP <- colMeans(normalized)
    masterfileLBP <- rbind(masterfileLBP, c(monumentName, clusterLine, centroidLBP))
    
    # LBP3x3
    if (length(correctlyClustered) == 0) {
      filteredData <- subset(dataLBP3x3, is.element(V1,as.vector(imgsOfCluster[,1])))
    } else {
      filteredData <- subset(dataLBP3x3, is.element(V1,as.vector(correctlyClustered)))
    }
    normalized <- t(apply(filteredData[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
    centroidLBP3x3 <- colMeans(normalized)
    masterfileLBP3x3 <- rbind(masterfileLBP3x3, c(monumentName, clusterLine, centroidLBP3x3))
  }
}

write.table(masterfileCM, 
"/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/centroids_CM.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

write.table(masterfileCM3x3, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/centroids_CM3x3.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

write.table(masterfileCN, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/centroids_CN.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

write.table(masterfileCN3x3, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/centroids_CN3x3.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

write.table(masterfileCSD, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/centroids_CSD.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

write.table(masterfileGLRLM, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/centroids_GLRLM.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

write.table(masterfileGLRLM3x3, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/centroids_GLRLM3x3.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

write.table(masterfileHOG, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/centroids_HOG.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

write.table(masterfileLBP, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/centroids_LBP.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

write.table(masterfileLBP3x3, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/centroids_LBP3x3.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)
