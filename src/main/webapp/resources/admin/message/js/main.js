$('#send_button').on('click', function (event) {
	event.preventDefault();
	var emailaddress = $('#con_email').text();
    var message = $('#text_write').val();
    $.getJSON('/api/rsa', function(result){
    	$('#loading').addClass('load_proc');
    	$('body').addClass('load_proc');
    	var publicKeyModulus = result.publicKeyModulus;
    	var publicKeyExponent = result.publicKeyExponent;
    	if(emailaddress != '' && message != ''){
        	$.ajax({
            	url:'/ms/s',
            	type:'post',
            	dataType:'text',
            	data: JSON.stringify({
            		'emailaddress': strEncrypted(emailaddress, publicKeyModulus, publicKeyExponent),
            		'message' : strEncrypted(message, publicKeyModulus, publicKeyExponent)
            	}),
            	headers:{
            		'Content-Type': 'application/json'
            	},
            	success:function(result){
            		alert('메시지를 보냈습니다.');
            		$('#loading').removeClass('load_proc');
                	$('body').removeClass('load_proc');
            		$('#text_write').empty();
            		$('#content_board').fadeOut(300);
            	},
            	statusCode:{
            		400: function(){
            			alert('메시지 전송에 실패했습니다.\n로그를 확인해 주세요.');
                    	$('#loading').removeClass('load_proc');
                    	$('body').removeClass('load_proc');
            		}
            	}
            })
        }else{
        	alert('메시지와 이메일은 필수요소입니다.');
        	$('#loading').removeClass('load_proc');
        	$('body').removeClass('load_proc');
        }
    });        
});

$('#list').on('click', '#message > a', function (event) {
	event.preventDefault();
    var cont_num = $(this).attr('href');
    $('#con_no').empty().append(cont_num);
    $('#con_date').empty().append($('#list #h_regdate.' + cont_num).val());
    $('#con_name').empty().append($('#list #h_name.' + cont_num).val());
    $('#con_email').empty().append($('#list #h_email.' + cont_num).val());
    $('#text_read').empty().append($('#list #h_message.' + cont_num).val());
    $('#content_board').fadeIn(300);
});

$('#exit_button').on('click', function (event) {
	event.preventDefault();
    $('#content_board').fadeOut(300);
});

function strEncrypted(str, publicKeyModulus, publicKeyExponent) {
    try {
        return submitEncryptedForm(str, publicKeyModulus, publicKeyExponent);
    } catch (err) {
        alert(err);
    }
    return false;
}

function submitEncryptedForm(str, rsaPublicKeyModulus, rsaPublicKeyExponent) {
    var rsa = new RSAKey();
    rsa.setPublic(rsaPublicKeyModulus, rsaPublicKeyExponent);
    var securedStr = rsa.encrypt(str);
    
    return securedStr;
}
