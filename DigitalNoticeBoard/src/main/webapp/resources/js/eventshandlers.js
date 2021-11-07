onBookMarkNotice = function(noticeId, username){
	   request = {};
	   request["noticeId"] = noticeId;
	   request["username"] = username;
	   axios.post('${contextPath}/api/bookmarkNotice', request)
	    .then(response => console.write(response.status)
	    .catch(error => {
	        console.error('There was an error!', error);
	    });
	};