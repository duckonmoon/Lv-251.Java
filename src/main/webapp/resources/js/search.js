/**
 * Created by Yana on 25.07.2017.
 */
$(document).ready(function() {
    $("#autocomplete").autocomplete({
        serviceUrl: '/all/doc',
        paramName: "name",
        delimiter: ",",
        transformResult: function (response) {
console.log("before"+response.toString());
            return {
                suggestions: $.map($.parseJSON(response), function (item) {
                    var i=item.firstname+" "+item.lastname+" "+item.specialization.name;
                    console.log(i);
                    return {value:i, data:item.id};
                })
            };
        },
        onSelect: function (suggestion) {
            console.log('You selected: ' + suggestion.value + ', ' + suggestion.data);
            var id=suggestion.data;
                $.ajax({
                    url:'/searchResult/'+id,
                    method:'GET',
                    contentType:'application/json',

                    success:function (result) {


                        console.log(result.firstname);
                        $("#content").empty();
                        $("#content").append("<div class='container'><div class='row row-content'><div class='container-fluid'>"+result.firstname+"" +
                            " "+result.lastname +"</div></div></div>")



                    }

                })

            }



    });
});

function task2() {
    var url='/search/'+$("#autocomplete").val();
    $.ajax({
        url:url,
        type:"GET",
        success:function (res) {
            console.log("222");
            $("#content").empty();
            for (var i = 0; i < res.length; i++) {
                console.log(res.length);
                $("#content").append(" <div class='row row-content'> <div class='container-fluid'> <div class='row'>"+
                    "<div class='col-xs-6 col-md-3'> <a href='#' class='thumbnail'>"+
                    "<img width=200' height='200' src='/resources/img/User_Default.png' alt='...'></a></div>"+
                    "<a href='"+"doctor/"+res[i].id+"'class='btn-link'><span class='doc-name'>"+res[i].firstname+"</span></a>"+
                    "<p><spring:message code='messages.specialization'/>:"+res[i].specialization.name+"</p> </div> </div>")
            }



        }
    });
}

function allDocs() {
          $("#autocomplete").autocomplete({
            serviceUrl: '/all/doc',
            paramName: "name",
            delimiter: ",",
            transformResult: function (response) {
                console.log("before"+response.toString());
                return {
                    suggestions: $.map($.parseJSON(response), function (item) {
                        var i=item.firstname+" "+item.lastname+" "+item.specialization.name;
                        console.log(i);
                        return {value:i, data:item.id};

                    })
                };
            },
            onSelect: function (suggestion) {
                console.log('You selected: ' + suggestion.value + ', ' + suggestion.data);
                var id=suggestion.data;
                $.ajax({
                    url:'/searchResult/'+id,
                    method:'GET',
                    contentType:'application/json',

                    success:function (result) {
                        console.log(result.firstname);
                        $("#content").empty();
                        $("#content").append("<a href='"+"/doctors/"+result.id+"'><div class='container'><div class='row row-content'><div class='container-fluid'>"+result.firstname+"" +
                            " "+result.lastname +"</div></div></div></a>")



                    }

                })

            }




    });
}