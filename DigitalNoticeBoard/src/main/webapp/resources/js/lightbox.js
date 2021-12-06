function closeLightBox(){
    document.getElementById('Lightbox').style.display = 'none';
}

function openLightBox(title,summary,details,createdAt,expirationDate, username,id) {
    document.getElementById('lightbox-notice-title').innerHTML = title;
    document.getElementById('lightbox-notice-summary').innerHTML = summary;
    document.getElementById('lightbox-notice-detail').innerHTML = details;
    var createdDate = new Date(createdAt);
    document.getElementById('lightbox-notice-createdAt').innerHTML = createdDate.toLocaleDateString('en-US');
    var expiredDate = new Date(expirationDate);
    document.getElementById('lightbox-notice-expirationDate').innerHTML = expiredDate.toLocaleDateString('en-US');
    var bookmarkelement = document.getElementById('lightbox-notice-bookmark')
    if(bookmarkelement != null)
    	bookmarkelement.setAttribute("onclick", "onBookMarkNotice('"+username+"', '"+id+"')");
    	
    document.getElementById('Lightbox').style.display = 'block';
}

function showNoticeTitle(n){
    document.getElementById('lightbox-notice-title').innerHTML = n
}

function showNoticeSummary(n){
    document.getElementById('lightbox-notice-summary').innerHTML = n
}

