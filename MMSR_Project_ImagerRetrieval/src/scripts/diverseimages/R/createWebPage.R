library(R2HTML)

# set up web page
target <- HTMLInitFile(file.path("/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages","webinterface"),"index", BackGroundColor="#DDDDDD")
HTML(as.title("Multimedia Search and Retrieval"),file=target)
HTML("<br> Example of a simple web interface for the project", file=target)

# load actual data
filepath <- "/home/alina/Documents/Universität/2016W/Multimedia Search and Retrieval/Project/MMSearch-Retrieval_2016_MainProject/MMSR_Project_ImagerRetrieval/src/scripts/diverseimages/retrievedImages.csv"
file <- read.csv(filepath, header=FALSE)


#filter for monument and show images
monumentName <- "cn_tower"

imagepath = "/home/alina/Documents/Universit&auml;t/2016W/Multimedia Search and Retrieval/Project/div-2014/devset/img/"
imageNames <- NULL
monumentList <- file[file[,1]==monumentName,]
HTML(paste("<br><br>", monumentName, "<br>", sep=""), file=target)

HTML("<table>", file=target)
for (i in seq(1,nrow(monumentList),3)) {
  path1 <- trimws(paste(imagepath, monumentName, "/", monumentList[i,3], ".jpg", sep=""))
  path2 <- trimws(paste(imagepath, monumentName, "/", monumentList[i+1,3], ".jpg", sep=""))
  path3 <- trimws(paste(imagepath, monumentName, "/", monumentList[i+2,3], ".jpg", sep=""))
    
  if (i < 12) {
    HTML(paste('<tr><td><img src="', path1, '" alt="', monumentName, '" style="width:75%;">', sep=""), file=target)
    HTML(paste(monumentList[i,3], ".jpg</td>", sep=""), file=target)
    HTML(paste('<td><img src="', path2, '" alt="', monumentName, '" style="width:75%;">', sep=""), file=target)
    HTML(paste(monumentList[i+1,3], ".jpg</td>", sep=""), file=target)
    HTML(paste('<td><img src="', path3, '" alt="', monumentName, '" style="width:75%;">', sep=""), file=target)
    HTML(paste(monumentList[i+2,3], ".jpg</td></tr>", sep=""), file=target)
  } else {
    break
  }
}
HTML("</table>", file=target)
HTML(paste0("<br><br><br>"), file=target)

HTMLEndFile()