files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/imgwiki", 
                    pattern="*CM.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
    t <- read.csv(file, header=FALSE)

  if (0 != length(grep("\\(*\\)", t[,2]))) {
    index <- grep("\\(*\\)", t[,2])
    
    t[index,1] <- paste0(t[index,1], ",", t[index,2])
    
    for (i in seq(3, ncol(t))-1) {
      t[index,i] <- t[index,i+1]
    }
    lastCol <- ncol(t)-1
    t <- t[1:lastCol]
  }
  
  if (is.character(t[,2])) {
    t[,2] <- as.numeric(t[,2])
  }
  
  normalized <- t(apply(t[-1], 1, function(x) {
    (x-min(x)) / (max(x)-min(x))
  }))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
  
}

write.table(masterfile, 
"/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_CM.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# ------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/imgwiki", 
                    pattern="*GLRLM.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
  t <- read.csv(file, header=FALSE)
  
  if (0 != length(grep("\\(*\\)", t[,2]))) {
    index <- grep("\\(*\\)", t[,2])
    
    t[index,1] <- paste0(t[index,1], ",", t[index,2])
    
    for (i in seq(3, ncol(t))-1) {
      t[index,i] <- t[index,i+1]
    }
    lastCol <- ncol(t)-1
    t <- t[1:lastCol]
  }
  
  if (is.character(t[,2])) {
    t[,2] <- as.numeric(t[,2])
  }
  
  normalized <- t(apply(t[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
}

write.table(masterfile, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_GLRLM.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)


# ------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/imgwiki", 
                    pattern="*CM3x3.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
  t <- read.csv(file, header=FALSE)
  
  if (0 != length(grep("\\(*\\)", t[,2]))) {
    index <- grep("\\(*\\)", t[,2])
    
    t[index,1] <- paste0(t[index,1], ",", t[index,2])
    
    for (i in seq(3, ncol(t))-1) {
      t[index,i] <- t[index,i+1]
    }
    lastCol <- ncol(t)-1
    t <- t[1:lastCol]
  }
  
  if (is.character(t[,2])) {
    t[,2] <- as.numeric(t[,2])
  }
  
  normalized <- t(apply(t[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
}

write.table(masterfile, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_CM3x3.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)


# ------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/imgwiki", 
                    pattern="*CN.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
  t <- read.csv(file, header=FALSE)
  
  if (0 != length(grep("\\(*\\)", t[,2]))) {
    index <- grep("\\(*\\)", t[,2])
    
    t[index,1] <- paste0(t[index,1], ",", t[index,2])
    
    for (i in seq(3, ncol(t))-1) {
      t[index,i] <- t[index,i+1]
    }
    lastCol <- ncol(t)-1
    t <- t[1:lastCol]
  }
  
  if (is.character(t[,2])) {
    t[,2] <- as.numeric(t[,2])
  }
  
  normalized <- t(apply(t[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
}

write.table(masterfile, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_CN.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# ------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/imgwiki", 
                    pattern="*CN3x3.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
  t <- read.csv(file, header=FALSE)
  
  if (0 != length(grep("\\(*\\)", t[,2]))) {
    index <- grep("\\(*\\)", t[,2])
    
    t[index,1] <- paste0(t[index,1], ",", t[index,2])
    
    for (i in seq(3, ncol(t))-1) {
      t[index,i] <- t[index,i+1]
    }
    lastCol <- ncol(t)-1
    t <- t[1:lastCol]
  }
  
  if (is.character(t[,2])) {
    t[,2] <- as.numeric(t[,2])
  }
  
  normalized <- t(apply(t[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
}

write.table(masterfile, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_CN3x3.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)


# ------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/imgwiki", 
                    pattern="*GLRLM3x3.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
  t <- read.csv(file, header=FALSE)
  
  if (0 != length(grep("\\(*\\)", t[,2]))) {
    index <- grep("\\(*\\)", t[,2])
    
    t[index,1] <- paste0(t[index,1], ",", t[index,2])
    
    for (i in seq(3, ncol(t))-1) {
      t[index,i] <- t[index,i+1]
    }
    lastCol <- ncol(t)-1
    t <- t[1:lastCol]
  }
  
  if (is.character(t[,2])) {
    t[,2] <- as.numeric(t[,2])
  }
  
  normalized <- t(apply(t[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
}

write.table(masterfile, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_GLRLM3x3.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)


# ------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/imgwiki", 
                    pattern="*LBP.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
  t <- read.csv(file, header=FALSE)
  
  if (0 != length(grep("\\(*\\)", t[,2]))) {
    index <- grep("\\(*\\)", t[,2])
    
    t[index,1] <- paste0(t[index,1], ",", t[index,2])
    
    for (i in seq(3, ncol(t))-1) {
      t[index,i] <- t[index,i+1]
    }
    lastCol <- ncol(t)-1
    t <- t[1:lastCol]
  }
  
  if (is.character(t[,2])) {
    t[,2] <- as.numeric(t[,2])
  }
  
  normalized <- t(apply(t[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
}

write.table(masterfile, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_LBP.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)


# ------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/imgwiki", 
                    pattern="*LBP3x3.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
  t <- read.csv(file, header=FALSE)
  
  if (0 != length(grep("\\(*\\)", t[,2]))) {
    index <- grep("\\(*\\)", t[,2])
    
    t[index,1] <- paste0(t[index,1], ",", t[index,2])
    
    for (i in seq(3, ncol(t))-1) {
      t[index,i] <- t[index,i+1]
    }
    lastCol <- ncol(t)-1
    t <- t[1:lastCol]
  }
  
  if (is.character(t[,2])) {
    t[,2] <- as.numeric(t[,2])
  }
  
  normalized <- t(apply(t[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
}

write.table(masterfile, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_LBP3x3.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)


# ------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/imgwiki", 
                    pattern="*HOG.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
  t <- read.csv(file, header=FALSE)
  
  if (0 != length(grep("\\(*\\)", t[,2]))) {
    index <- grep("\\(*\\)", t[,2])
    
    t[index,1] <- paste0(t[index,1], ",", t[index,2])
    
    for (i in seq(3, ncol(t))-1) {
      t[index,i] <- t[index,i+1]
    }
    lastCol <- ncol(t)-1
    t <- t[1:lastCol]
  }
  
  if (is.character(t[,2])) {
    t[,2] <- as.numeric(t[,2])
  }
  
  normalized <- t(apply(t[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
}

write.table(masterfile, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_HOG.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)

# ------
rm(list=ls())

files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/testset/descvis/imgwiki", 
                    pattern="*CSD.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
  t <- read.csv(file, header=FALSE)
  
  if (0 != length(grep("\\(*\\)", t[,2]))) {
    index <- grep("\\(*\\)", t[,2])
    
    t[index,1] <- paste0(t[index,1], ",", t[index,2])
    
    for (i in seq(3, ncol(t))-1) {
      t[index,i] <- t[index,i+1]
    }
    lastCol <- ncol(t)-1
    t <- t[1:lastCol]
  }
  
  if (is.character(t[,2])) {
    t[,2] <- as.numeric(t[,2])
  }
  
  normalized <- t(apply(t[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
}

write.table(masterfile, 
            "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/relevantimages/centroids_CSD.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)