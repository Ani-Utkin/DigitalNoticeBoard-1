function onBookMarkNotice(username, noticeId){
	   let request = {};
	   request["noticeId"] = noticeId;
	   request["username"] = username;
	  $.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.origin + "/api/bookmarkNotice",
			data : JSON.stringify(request),
  			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
					console.log("Saved:result.data");
				}else{
					alert("Error!");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});	
	}