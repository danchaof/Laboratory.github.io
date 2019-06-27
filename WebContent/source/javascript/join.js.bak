window.onload = function() {
				var tijiao = document.getElementById("tijiao");
				var name = document.getElementById("name");
				var sex = document.getElementById("sex");
				var zy = document.getElementById("zy");
				var bm = document.getElementById("bm");
				var xh = document.getElementById("xh");
				var tel = document.getElementById("tel");
				var jn = document.getElementById("jn");
				var nl = document.getElementById("nl");
				var name_length = 0;
				
				var jinggao = document.getElementsByClassName('jinggao');
				
				function getLength(str){
					return str.length;
				};
				
//				姓名的验证
				name.onfocus = function() {		
					jinggao[0].style.display = 'block';
					jinggao[0].innerHTML = '2-3个字符组成';
				};
				
				name.onkeyup = function() {
					name_length = getLength(this.value)
				};
				
				name.onblur = function() {
					if(name_length < 2 && name_length>0){
						jinggao[0].innerHTML = '长度少于2个字符';
					}
					else if(name_length>8){
						jinggao[0].innerHTML = '长度大于8个字符';
						
					}
					else if(name_length==0){
						jinggao[0].innerHTML = '不能为空';
					}
					else{
						jinggao[0].innerHTML = 'OK';
					}
				}
				
//				性别的验证：
				
				
				sex.onkeyup = function() {
					name_length = getLength(this.value)
				};
				
				sex.onblur = function() {
					if(this.value == '男' || this.value == '女'){
						
						jinggao[1].innerHTML = 'OK';
					}
					else {
						jinggao[1].innerHTML = '请输入：男或女';
						
					}
		
				}
				
//				专业班级验证
				

				zy.onkeyup = function() {
					name_length = getLength(this.value)
				};
				
				zy.onblur = function() {
					var regex2 = new RegExp ("^16级.","g")
					var istrue = regex2.test(this.value);
					if(istrue){				
						jinggao[2].innerHTML = 'OK';
					
					}
					else if(name_length == 0) {
						jinggao[2].innerHTML = '不能为空';
						
					}
					else {
						jinggao[2].innerHTML = '格式错误';
						
					}
		
				}
				
				//学号验证		
				xh.onkeyup = function() {
					name_length = getLength(this.value)
				};
				
				xh.onblur = function() {
					var regex4 = new RegExp("^1603[0-9]{7}","g");
					var istrue = regex4.test(this.value);
					if(istrue && name_length == 11){
						
						jinggao[4].innerHTML = 'OK';
					}
					else if(name_length == 0){
						jinggao[4].innerHTML = '不能为空';
						
					}
					else {
						jinggao[4].innerHTML = '学号格式错误';
					}
		
				}
				
				//专业技能与自我能力验证
				jn.onkeyup = function() {
					name_length = getLength(this.value)
				};
				
				jn.onblur = function() {
					if(name_length <= 1000){
						
						jinggao[6].innerHTML = 'OK';
					}
					else {
						jinggao[6].innerHTML = '长度大于1000';
						
					}
				}
				
				nl.onkeyup = function() {
					name_length = getLength(this.value)
				};
				
				nl.onblur = function() {
					if(name_length <= 1000){
						
						jinggao[7].innerHTML = 'OK';
					}
					else {
						jinggao[7].innerHTML = '长度大于1000';
						
					}
		
				}
				
				
				//手机号码验证
				tel.onkeyup = function() {
					name_length = getLength(this.value)
				};
				
				tel.onblur = function() {
					if(name_length == 11){
						
						jinggao[5].innerHTML = 'OK';
					}
					else {
						jinggao[5].innerHTML = '请输入11位手机号码';
						
					}
		
				}
				
				
				
				
				
				
				tijiao.onclick = function(){
					var urlshuju =  "name=" + document.getElementById("name").value +  
								"&sex=" + document.getElementById("sex").value +
								"&zy=" + document.getElementById("zy").value +
								"&bm=" + document.getElementById("bm").value +
								"&xh=" + document.getElementById("xh").value +
								"&tel=" + document.getElementById("tel").value +
								"&jn=" + document.getElementById("jn").value +
								"&nl=" + document.getElementById("nl").value;
//					alert(urlshuju);
					var request = new XMLHttpRequest();	
					request.onreadystatechange = function() {
						if(request.readyState == 4) {
							if((request.status >= 200 && request.status < 300) || request.status == 304) {
								alert('提交成功')
								alert(request.responseText);
								
							}
							else {
								alert("提交失败 ：" + request.status);
							}
						}
					};
					
					
					request.open("GET","#?"+urlshuju,true);
					request.send();
					
				}
				
				
			}