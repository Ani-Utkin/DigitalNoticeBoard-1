function closeLightBox(){
    document.getElementById('Lightbox').style.display = 'none';
}

function openLightBox() {
    document.getElementById('Lightbox').style.display = 'block';
}

function showNoticeTitle(n){
    document.getElementById('lightbox-notice-title').innerHTML = n
}

function showNoticeSummary(n){
    document.getElementById('lightbox-notice-summary').innerHTML = n
}

function showEmailNoticeTitle(n){
    document.getElementById('email-title').value = n
}

function showEmailNoticeSummary(n){
    document.getElementById('email-text').value = n
}

function showNoticeCreateDate(n){
    // document.getElementById('lightbox-notice-creationtime').value = n
}

function showNoticeExpireDate(n){
   // document.getElementById('lightbox-notice-expirationtime').value = n
}
