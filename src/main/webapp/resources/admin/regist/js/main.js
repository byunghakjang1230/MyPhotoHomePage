var result_tample = Handlebars.compile($('#result_tample').html());
var subcate_tample = Handlebars.compile($('#subcate_tample').html());
var change_switch = false;
var before_num = 0;
var after_num = 0;

var file_count = 0;
var upload_count = 0;

//////////////////////////////////////////////
//				임시폴터 초기화 요청				//
var registPageInit = function(){
	$('#loading').addClass('load_proc');
	$('body').addClass('load_proc');
	$.ajax({
		url:'/ir/init',
		type: 'get',
		dataType: 'text',
		success: function(result){
			alert('반갑습니다.');
			$('#loading').removeClass('load_proc');
            $('body').removeClass('load_proc');
		}
	});
	$('#loading').removeClass('load_proc');
    $('body').removeClass('load_proc');
}


////////////////////////////////////////////////
////리스트에 번호 붙이기.(초기화)			////
var setLiClassNum = function () {
	$('#result_ > ul > li').removeClass();
	var count = $('#result_ > ul > li').length;
	for (var i = 0; i < count; i++) {
		$('#result_ > ul > li:nth-child(' + (i + 1) + ')').attr('class', i);
	}
}

//////////////////////////////////////////////
//		파일 이벤트와 관련된 함수들.				//

var dragNdropInput = function(event){
	var files = event.originalEvent.dataTransfer.files;
	file_count = files.length;
	[].forEach.call(files, readfile);
}

var inputTagInput = function(event){
	var files = event.target.files;
	
	[].forEach.call(files, readfile);
}


var readfile = function (file) {
	var reader = new FileReader();
	reader.addEventListener('load', function () {
		imgUpload(file);
	}, false);
	reader.readAsDataURL(file);
}

//아래 매서드를 필요에 따라 새로 정의.
var imgUpload = function (file) {
	upload_count++;
	var formData = new FormData();
	formData.append('imgfile', file);
	$.ajax({
		url: '/ir/temp',
		type: 'post',
		dataType: 'json',
		data: formData,
		processData: false,
		contentType: false,
		success: function (data) {
			$('#result_ > ul').append(result_tample(data));
			if(file_count == upload_count){
				file_count = upload_count = 0;
				$('#loading').removeClass('load_proc');
                $('body').removeClass('load_proc');
			}
		},
		statusCode:{
			500: function(result){
				alert('업로드에 실패했습니다.');
				$('#loading').removeClass('load_proc');
                $('body').removeClass('load_proc');
			}
		}
	});
	setLiClassNum();
}

//////////////////////////////////////////////
//		파일 submit때 수행될 함수. 				//
var getFileValues = function (count) {
    var photo_info = [];
    var maincate = $('#maincate').val();
    var subcate = $('#subcate').val();
    for (var i = 0; i < count; i++) {
        var photo = {
            'maincate': maincate,
            'subcate': subcate,
            'title': $('#result_ > ul > li.' + i + ' #title').val(),
            'context': $('#result_ > ul > li.' + i + ' #context').val(),
            'filename': $('#result_ > ul > li.' + i + ' #filename').val(),
            'thumbname': $('#result_ > ul > li.' + i + ' #thumbname').val()
        }
        photo_info.push(photo);
    }
    return photo_info;
}

////////////////////////////////////////////////////////////

registPageInit();

$('#send_bt').on('click', function (event) {
    event.preventDefault();
    var count = $('#result_ > ul > li').length;
    if (count > 0) {
    	$('#loading').addClass('load_proc');
    	$('body').addClass('load_proc');
    	
        $.ajax({
            url: '/ir/reg',
            type: 'post',
            dataType: 'text',
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(getFileValues(count)),
            success: function (result) {
                alert('등록되었습니다.')
                $('#loading').removeClass('load_proc');
                $('body').removeClass('load_proc');
                $('#result_ > ul').empty();
            },
            statusCode: {
                400: function () {
                    alert('등록에 실패했습니다.\n다시 시도해주세요.');
                    $('#loading').removeClass('load_proc');
                    $('body').removeClass('load_proc');
                },
                401: function(){
                	alert('권한이 없습니다.');
                	$('#loading').removeClass('load_proc');
                    $('body').removeClass('load_proc');
                }
            }
        });
    }
});

$('#result_ > ul').on('DOMNodeInserted', function () {
	setLiClassNum();
});

$('#result_').on('click', '#change', function () {
    var empty = $(this).parent().parent().parent().attr('class');
    if (change_switch == false) {
        before_num = empty;
        $(this).addClass('selected');
        change_switch = true;
    } else {
        after_num = empty;
        if (after_num < before_num) {
            $('#result_ li.' + after_num).before($('#result_ li.' + before_num));
        } else if (after_num > before_num) {
            $('#result_ li.' + after_num).after($('#result_ li.' + before_num));
        }
        $('#change.selected').removeClass('selected');
        setLiClassNum();
        change_switch = false;
    }
});

$('#maincate').on('change', function () {
    var maincate = $(this).val();
    $.getJSON('/ir/ct/' + maincate, function (data) {
			$('#subcate').empty().append(subcate_tample(data));
	});
});

$('*').on('dragenter dragover drop', function (event) {
	event.preventDefault();
});

$('#input_field_').on('drop', function (event) {
	event.preventDefault();
	$('#loading').addClass('load_proc');
	$('body').addClass('load_proc');
    dragNdropInput(event);
});

$('#img_in').on('click', function (event) {
	event.preventDefault();
    $('#file').trigger('click');
});

$('#file').on('change', function (event) {
	event.preventDefault();
    inputTagInput(event);
});
        
$('#result_').on('click', '#del', function (event) {
	event.preventDefault();
    var thumbname = $(this).parent().parent().find('#thumbname').val();
    var filename = $(this).parent().parent().find('#filename').val();
    var del_li = $(this).parent().parent().parent();
    if(thumbname != '' && filename != ''){
    	$.ajax({
    		url: '/ir/del',
            type: 'post',
            dataType: 'text',
            data: JSON.stringify({
            	'filename': filename,
                'thumbname': thumbname
            }),
            headers: {
            	'Content-Type': 'application/json'
            },
            success: function (result) {
            	del_li.remove();
            	setLiClassNum();
            },
            statusCode: {
            	400 : function(){
            		alert('데이터 처리중입니다.\n잠시뒤 시도해 주세요.');
            	},
            	401 : function(){
            		alert('권한이 없습니다.');
                	$('#loading').removeClass('load_proc');
                    $('body').removeClass('load_proc');
            	}
            }                    
    	});
    }else{
    	alert('파일 이름이 없습니다.');
    }            
});

