

var modList = ['d', 'm', 'y', 't'];
var textArray = [
	'오늘 방문자 : ',
	'이번달 방문자 : ',
	'올해 방문자 : ',
	'전체 방문자 : '
];
var docArray = [
	document.querySelector('#today #chart'),
	document.querySelector('#month #chart'),
	document.querySelector('#year #chart'),
	document.querySelector('#total #chart')
];

var optionArray = [];
var dataArray = [];


google.charts.load('current', { 'packages': ['corechart'] });
google.charts.setOnLoadCallback(drawChart);

var getDataFunction = function(mode, hText, docM){
	$.getJSON('/api/vs/'+mode, function(data){
        var visiterArr = data.visiter;
        var finalData = [];
        var option = {
            	title: hText + data.count,
                titleTextStyle: {
                	fontSize: 15
        			},
        			chartArea: { left: 20, width: '90%', height: '80%' }
            };
        
        finalData.push(['Task', 'Hours per Day']);
        for (var i = 0; i < visiterArr.length; i++) {
            finalData.push([visiterArr[i].country, visiterArr[i].count]);
        }
        var data = google.visualization.arrayToDataTable(finalData);
		var chart = new google.visualization.PieChart(docM);
		chart.draw(data, option);
	});
}

function drawChart() {
	getDataFunction(modList[0], textArray[0], docArray[0]);
	getDataFunction(modList[1], textArray[1], docArray[1]);
	getDataFunction(modList[2], textArray[2], docArray[2]);
	getDataFunction(modList[3], textArray[3], docArray[3]);
}




var map;
function initMap() {
	$.getJSON('/api/vp', function(data){
		var locations = data;
		map = new google.maps.Map(document.getElementById('map'), {
	        center: { lat: 37.34, lng: 126.5841 },
	        zoom: 2
	    });
	    var marker;
	    for (var i = 0; i < locations.length; i++) {
	        marker = new google.maps.Marker({
	            position: locations[i],
	            map: map
	        });
	    }		
	});	
    
};