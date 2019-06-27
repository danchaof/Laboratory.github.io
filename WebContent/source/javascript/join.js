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

	function getLength(str) {
		return str.length;
	}
	;

	//	姓名的验证
	/*name.onfocus = function() {
		jinggao[0].style.display = 'block';
		jinggao[0].innerHTML = '不能为空';
	};*/

	name.onkeyup = function() {
		name_length = getLength(this.value)
	};
   name.onclick=function()
   {
	   if(this.value=="")
		  name_length=0; 
   }
	name.onblur = function() {
		var regex2 = new RegExp(/\s/, "g")
		var istrue = regex2.test(this.value);
		if (name_length < 2 && name_length > 0) {
			jinggao[0].innerHTML = '长度少于2个字符';
		} else if (name_length > 8) {
			jinggao[0].innerHTML = '长度大于8个字符';
		} else if (name_length == 0) {
			jinggao[0].innerHTML = '不能为空';
		} else {
			jinggao[0].innerHTML = 'OK';
		}
		if (istrue) {
			jinggao[0].innerHTML = '不能输入空格';
		}
	}

	//	性别的验证：

	sex.onkeyup = function() {
		name_length = getLength(this.value)
	};
	 sex.onclick=function()
	   {
		   if(this.value=="")
			  name_length=0; 
	   }
	sex.onblur = function() {
		if (this.value == '男' || this.value == '女') {

			jinggao[1].innerHTML = 'OK';
		} else {
			jinggao[1].innerHTML = '不能为空';

		}

	}
	//	专业班级验证

	zy.onkeyup = function() {
		name_length = getLength(this.value)
	};
	 zy.onclick=function()
	   {
		   if(this.value=="")
			  name_length=0; 
	   }
	zy.onblur = function() {
		var regex2 = new RegExp(/^\d\d级[\u4e00-\u9fa5]+/, "g")
		var istrue = regex2.test(this.value);
		if (istrue) {
			jinggao[2].innerHTML = 'OK';

		} else if (name_length == 0) {
			jinggao[2].innerHTML = '不能为空';

		} else {
			jinggao[2].innerHTML = '不能为空';
		}

	}
	//	加入部门验证

	bm.onkeyup = function() {
		name_length = getLength(this.value)
	};
	 bm.onclick=function()
	   {
		   if(this.value=="")
			  name_length=0; 
	   }
	bm.onblur = function() {
		var regex3 = new RegExp(/^[\u4e00-\u9fa5]+/, "g")
		var istrue = regex3.test(this.value);
		if (istrue) {
			jinggao[3].innerHTML = 'OK';
		} else {
			jinggao[3].innerHTML = '不能为空';
		}

	}
	//学号验证		
	xh.onkeyup = function() {
		name_length = getLength(this.value)
	};
	 xh.onclick=function()
	   {
		   if(this.value=="")
			  name_length=0; 
	   }
	xh.onblur = function() {
		var regex4 = new RegExp(/^[0-9]{11}/, "g");
		var istrue = regex4.test(this.value);
		if (istrue && name_length == 11) {
			jinggao[4].innerHTML = 'OK';
		} else if (name_length == 0) {
			jinggao[4].innerHTML = '不能为空';

		} else {
			jinggao[4].innerHTML = '学号格式错误';
		}

	}
	//手机号验证		
	tel.onkeyup = function() {
		name_length = getLength(this.value)
	};
	 tel.onclick=function()
	   {
		   if(this.value=="")
			  name_length=0; 
	   }
	tel.onblur = function() {
		var regex5 = new RegExp(/^[0-9]{11}/, "g");
		var istrue = regex5.test(this.value);
		if (istrue && name_length == 11) {
			jinggao[5].innerHTML = 'OK';
		} else if (name_length == 0) {
			jinggao[5].innerHTML = '不能为空';
		} else {
			jinggao[5].innerHTML = '手机号输入错误';
		}

	}
	//专业技能验证
	jn.onkeyup = function() {
		name_length = getLength(this.value)
	};
	 jn.onclick=function()
	   {
		   if(this.value=="")
			  name_length=0; 
	   }
	jn.onblur = function() {
		var regex6 = new RegExp(/\S/, "g")
		var istrue = regex6.test(this.value);
		if (name_length <= 1000 && istrue) {
			jinggao[6].innerHTML = 'OK';
		} else if (!istrue) {
			jinggao[6].innerHTML = '不能为空';
		}
	}
	//自我能力验证
	nl.onkeyup = function() {
		name_length = getLength(this.value)
	};
	 nl.onclick=function()
	   {
		   if(this.value=="")
			  name_length=0; 
	   }
	nl.onblur = function() {
		var regex7 = new RegExp(/\S/, "g")
		var istrue = regex7.test(this.value);
		if (name_length <= 1000 && istrue) {
			jinggao[7].innerHTML = 'OK';
		} else if (!istrue) {
			jinggao[7].innerHTML = '不能为空';
		}

	}

	tijiao.onclick = function() {
		if (name.value == "" || sex.value == "" || zy.value == ""
				|| bm.value == "" || xh.value == "" || tel.value == ""
				|| jn.value == "" || nl.value == "") {
			alert("提交失败 ，请检查信息是否填写完整!");
			return;
		}

		var urlshuju = "name=" + document.getElementById("name").value
				+ "&sex=" + document.getElementById("sex").value + "&zy="
				+ document.getElementById("zy").value + "&bm="
				+ document.getElementById("bm").value + "&xh="
				+ document.getElementById("xh").value + "&tel="
				+ document.getElementById("tel").value + "&jn="
				+ document.getElementById("jn").value + "&nl="
				+ document.getElementById("nl").value;
		//	alert(urlshuju);
		var request = new XMLHttpRequest();
		request.onreadystatechange = function() {
			if (request.readyState == 4) {
				if ((request.status >= 200 && request.status < 300)
						|| request.status == 304) {
					if (request.responseText == "注册信息成功！") {
						alert(request.responseText);
						document.location = 'index.html';
					} else {
						alert(request.responseText);
					}

				} else {
					alert("请求失败 ：" + request.status);
				}
			}
		};

		request.open("POST", "/Laboratory/LaboratoryServlet", true);
		request.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		request.send(urlshuju)

	};

};