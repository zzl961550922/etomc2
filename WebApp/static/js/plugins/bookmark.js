/*
 *	############################################################################
 *	
 *   bookmark
 *   
 *	############################################################################
 */

// act 1 code 2 stra
function ListBookMarksCode(act, cid) {
	
	$.ajax({
				url : DomainUrl+"/bookmark?jsoncallback=?",
				contentType : 'text/html;charset=utf-8',
				data : {
					"act" : act,
					"cid":cid
				},
				success : function(result) {
					// console.log("success" + result);
				},
				error : function(request, textStatus, errorThrown) {
					// alert(textStatus);
				},
				complete : function(request, textStatus) { // for additional
															// info
					var option = request.responseText;
					if(option.length < 5) return;
					//console.log("option:" + option);
					var Json = JSON.parse(option);
					var html="";
					for(var i=0; i<Json.length; i++){
						html += "<tr>"+
									"<th scope='row'>"+(i+1)+"</th>"+
									"<td>"+"<a href=''><code>"+
												"<i class='fa fa-star'></i>"+Json[i]['code']+" "+Json[i]['name']+
											"</code>"+
									"</a></td>"+
									"<td>dd</td>"+
									"<td>dd</td>"+
									"<td><button title='Success' class='btn btn-outline btn-success' type='button'" +
											" onclick='ListBookMarksStra(\""+Json[i]['code']+"\",\""+Json[i]['name']+"\", "+cid+", "+i+")'>"+
											"<i class='fa fa-close'  id='bmlist_"+i+"' id='bmlist_"+i+"'></i><span class='sr-only'>Success</span>"+
										"</button></td>"+
								"</tr>";
					}
										
					$("#bookMarkCodeList").html(html);
					ListBookMarksStra(Json[0]['code'], Json[0]['name'], cid, 0);
				}
			});
}

function ListBookMarksStra(code, name, cid, i){		
	
	for (n = 0; n < 3; n++) {
		$("#bmlist_" + n).attr("class", "fa fa-close");
	}

	$("#bmlist_" + i).attr("class", "fa fa-check");
	
	$("#code_num").val(code);
	
	$("#CodeAndName").html(code+" "+name);
	
	addCode(code, name);
		
	$.ajax({
		url : DomainUrl+"/bookmark?jsoncallback=?",
		contentType : 'text/html;charset=utf-8',
		data : {
			"act" : 2,
			"cid": cid,
			"code": code
		},
		success : function(result) {
			// console.log("success" + result);
		},
		error : function(request, textStatus, errorThrown) {
			// alert(textStatus);
		},
		complete : function(request, textStatus) { // for additional
													// info
			var option = request.responseText;
			//console.log("option:" + option);
			var Json = JSON.parse(option);
			var htmlList="";
			for(var i=0; i<Json.length; i++){
				 htmlList += "<tr id="+i+">"+
								"<th scope='row'></th>"+
								"<td>"+Json[i]['title']+"</td>"+
								"<td>10%</td>"+
								"<td>5.6</td>"+
								"<td><button title='Success' class='btn btn-outline btn-success' type='button' onclick='istrSelect2(\""+Json[i]['title']+"\", \""+Json[i]['id']+"\", "+i+")'>"+
								"<i class='fa fa-close' id='bmslist_"+i+"' id='bmslist_"+i+"'></i><span class='sr-only'>Success</span>"+
								"</button></td>"+
							"</tr>";
			}
//			$("#bmlist_"+i).attr("class", "fa fa-check");
			$("#nowCodeStraList").html(htmlList);						
		}
	});
	
}


function addBookMark(i, cid) {
	
	var code = $("#code_num").val();
	if(StockCode.length != 0){
		code = StockCode;
	}
		
	var dataList = 'act=' + i+"&sid=" + straListData[nowTId]['id'] + "&code=" + code +"&name="+StockCodeName+"&cid="+cid ;
		
	$.ajax({
		url : DomainUrl+"/bookmark?jsoncallback=?",
		contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
		data : dataList,
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			// console.log(response.status);

		},
		complete : function(request, textStatus) {
			var option = request.responseText;
			//console.log("option:" + option);
			var i = parseInt(option);
			var msg = "添加成功!";
			if(i==-1){
				msg = "参数有问题";
			}else if(i==-2){
				msg = "策略已达组合最大值";
			}else if(i==-3){
				msg = "策略已存在，不必再次添加";
			}else if(i==-4){
				msg = "股票数量已达组合最大值";
			}
									
			BellNotifi(msg);
		},
		error : function(response) {
			// console.log(response);
		}
	});
}