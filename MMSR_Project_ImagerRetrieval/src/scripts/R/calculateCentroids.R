files <- list.files(path="/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/descvis/imgwiki", 
                    pattern="*GLRLM.csv", full.names=T, recursive=FALSE)

masterfile <- NULL
for (file in files) {
  t <- read.csv(file, header=FALSE)
  
  normalized <- t(apply(t[-1], 1, function(x)(x-min(x))/(max(x)-min(x))))
  
  # calculate centroids
  centroid <- colMeans(normalized)
  name <- substr(t[1,1],1,regexpr('\\(', t[1,1])-1)
  masterfile <- rbind(masterfile, c(name, centroid))
}

write.table(masterfile, 
"/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/centroids_GLRLM.csv",
            sep=",", quote=FALSE, row.names=F, col.names=F)