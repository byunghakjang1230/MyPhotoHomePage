var name_c = false;
var email_c = false;
var message_c = false;
var insta_tample = Handlebars.compile($('#insta_tample').html());

$.getJSON('/api/insta', function (data) {
	$('#info div.row').append(insta_tample(data));
});

$('.in_d').on('focusin', function () {
	$(this).removeClass('empty');
});
            
            
            
$('#submit_bt').on('click', function (event) {
	event.preventDefault();
    var message = $('#message_').val();
    var name = $('#name_').val();
    var email = $('#email_').val();

    var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

    if (exptext.test(email) == true)
    	email_c = true;
    if (message != '')
    	message_c = true;
    if (name != '')
    	name_c = true;

    if (name_c && message_c && email_c == true) {
    	$.getJSON('/api/rsa', function(data){
    		var publicKeyModulus = data.publicKeyModulus;
    		var publicKeyExponent = data.publicKeyExponent;
    		$.ajax({
        		url: '/ms/r',
                type: 'post',
                dataType: 'text',
                data: JSON.stringify({
                	'name': strEncrypted(name, publicKeyModulus, publicKeyExponent),
                	'email': strEncrypted(email, publicKeyModulus, publicKeyExponent),
                    'message': strEncrypted(message, publicKeyModulus, publicKeyExponent)
                }),
                headers: {
                	'Content-Type':'application/json'
                },
                success: function (result) {
                	alert('Your message has been successfully sent!');
                	$('#message_').empty();
                    $('#name_').empty();
                    $('#email_').empty();
                },
                statusCode:{
                	400: function(){
                		alert('Failed to send message.\nPlease try again later.');
                	},
                	403: function(){
                		alert('you have already sent Message.\nsee you next time. :)');
                	}
                }
        	});
    	}).fail(function(result){
    		alert(result);
    	});
    } else {
    	if (email_c == false)
    		$('#email_').addClass('empty');

    	if (message_c == false)
    		$('#message_').addClass('empty');

    	if (name_c == false)
    		$('#name_').addClass('empty');
    }
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