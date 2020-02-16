$(document).ready(function(){
	getNotifications()
	$('[data-toggle="tooltip"]').tooltip();

	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;
			});
		} else{
			checkbox.each(function(){
				this.checked = false;
			});
		}
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});

});

function savePerson(){

		var info = {
			name: $("#name").val(),
			lastname: $("#lastname").val(),
			proccess: $("#proccess").val()
		}
		$.ajax({
			url:"http://localhost:8080/api/persons",
			method:"POST",
			data:JSON.stringify(info),
			dataType:"json",
			contentType: 'application/json',
			success:function(data)
			{
				$('#form-person')[0].reset();
				$("#addEmployeeModal").modal("toggle");
				location.reload();
			}
		})
	event.preventDefault();
}

function getNotifications() {

	$.ajax({
		url: "http://localhost:8080/api/persons",
		method: "GET",
		dataType: "json",
		success: function (data) {
				for (let i = 0; i < data.length; i++) {
					const element = data[i];
					var proccess = (element.proccess)?  '<b style="color: #228B22;">Procesado</b>' : '<b style="color: #B22222;">NO Procesado</b>';
					var html = '<tr>';
					html += '<td><span class="custom-checkbox">';
					html += '<input type="checkbox" id="checkbox1" name="options" value="'+ element.id +'">';
					html +=	'<label for="checkbox1"></label>';
					html += '</span></td>';
					html += '<td>' + element.name + '</td>';
					html += '<td>' + element.lastname + '</td>';
					html += '<td>' + proccess +'</td>';
					html += '</tr>';
					$('#table_data').prepend(html);
				}
		}
	});
}

function saveProccess(){
	var info = [];
	$.each($("input[name='options']:checked"), function(){
			info.push($(this).val());
	});
	$.ajax({
		url:"http://localhost:8080/api/proccess",
		method:"POST",
		data:JSON.stringify(info),
		dataType:"json",
		contentType: 'application/json',
		success:function(data)
		{
			location.reload();
		}
	})
}
