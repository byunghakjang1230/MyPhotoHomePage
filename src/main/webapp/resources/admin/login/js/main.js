		var loginFunction = function(){
			var id = $('#normid').val();
            var pass = $('#normpassword').val();
            
            if (id == '' || pass == '') {
                if (id == '')
                    $('#normid').parent().addClass('has-error');
                if (pass == '')
                    $('#normpassword').parent().addClass('has-error');
            } else {
            	$.getJSON('/api/rsa', function(result){
                	var publicKeyModulus = result.publicKeyModulus;
                	var publicKeyExponent = result.publicKeyExponent;
                	validateEncryptedForm(id, pass, publicKeyModulus, publicKeyExponent);
                });
            }
		}

		$('#submit').on('click', function (event) {
            event.preventDefault();
            loginFunction();
        });
		
		$('#normpassword').on('keypress', function(event){
			if(event.which == 13)
				loginFunction();
		});
		
        $('input').on('focusin', function (event) {
            event.preventDefault();
            $(this).parent().removeClass('has-error');
        });

        function validateEncryptedForm(id, password, publicKeyModulus, publicKeyExponent) {
            try {
                submitEncryptedForm(id, password, publicKeyModulus, publicKeyExponent);
            } catch (err) {
                alert(err);
            }
            return false;
        }

        function submitEncryptedForm(id, password, rsaPublicKeyModulus, rsaPublicKeyExponent) {
            var rsa = new RSAKey();
            rsa.setPublic(rsaPublicKeyModulus, rsaPublicKeyExponent);
            var securedPassword = rsa.encrypt(password);
            var securedId = rsa.encrypt(id);

            var securedLoginForm = $('#loginform');
            $('#id').val(securedId);
            $('#password').val(securedPassword);
            securedLoginForm.submit();
        }