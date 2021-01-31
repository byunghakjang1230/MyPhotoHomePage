$('#header a.linktogm').on('click', function (event) {
	event.preventDefault();
	var href = $(this).attr('href');
    $('body').addClass('linktogm');
    setTimeout(function(){
    	location.href = href;
    }, 650);
});

$('#header a.linktopf').on('click', function (event) {
	event.preventDefault();
	var href = $(this).attr('href');
    $('body').addClass('linktopf');
    setTimeout(function(){
    	location.href = href;
    }, 650);
});

/*******************************************************/
var name_c = false;
var email_c = false;
var message_c = false;

$('.in_d').on('focusin', function () {
    $(this).removeClass('empty');
});

$('#submit_bt').on('click', function (event) {
    event.preventDefault();
    
    var message = $('#message').val();
    var name = $('#name').val();
    var email = $('#email').val();

    var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

    if (exptext.test(email) == true)
        email_c = true;
    if (message != '')
        message_c = true;
    if (name != '')
        name_c = true;

    if (name_c && message_c && email_c == true) {
    	$.getJSON('/ms/r', function(data){
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
    	});      
    } else {
        if (email_c == false)
            $('#email').addClass('empty');

        if (message_c == false)
            $('#message').addClass('empty');

        if (name_c == false)
            $('#name').addClass('empty');
    }
    
});

/*******************************************************/
var bg_list = [];

var start = 0;
var end = $('#bg_list #bg_url').length - 1;

for (var i = 0; i < $('#bg_list #bg_url').length; i++) {
	bg_list.push($('#bg_list #bg_url:nth-child(' + (i + 1) + ')').val());
}

$('#bg').css({ 'background-image': 'url("' + bg_list[start++] + '")' });

setInterval(function () {
	$('#bg').fadeOut(1000, function () {
	$(this).css({ 'background-image': 'url("' + bg_list[start++] + '")' });
	}).fadeIn(1000);
	if (start > end)
		start = 0;
}, 10 * 1000);

/********************* RSA Function *************************/
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