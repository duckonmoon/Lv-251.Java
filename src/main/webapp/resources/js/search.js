/**
 * Created by Yana on 25.07.2017.
 */
$(document).ready(function() {
    $("#autocomplete").autocomplete({
        serviceUrl: '/all/doc',
        paramName: "name",
        delimiter: ",",
        transformResult: function (response) {
console.log("before");
            return {

                suggestions: $.map($.parseJSON(response), function (item) {
                    console.log(item);
              var i=item.firstname+" "+item.lastname+" "+item.specialization.name;
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

$("#search-doctor").click(function () {
    console.log($("#autocomplete").val());
    var  n=$("#autocomplete").val();
    $.ajax({
        url:'/search/'+n,
        type:"GET",
        contentType:'application/json',
        success:function (res) {
            console.log(res.length);
            console.log(res.toString());
            $.each(function (res,item) {
                $("#content").empty();
                $("#content").append(" <div class='row row-content'> <div class='container-fluid'> <div class='row'>"+
                    "<div class='col-xs-6 col-md-3'> <a href='#' class='thumbnail'>"+
                    "<img width=200' height='200' src='/resources/img/User_Default.png' alt='...'></a></div>"+
                    "<a href='"+"doctor/"+item.id+"'class='btn-link'><span class='doc-name'>"+item.firstname+"</span></a>"+
                    "<p><spring:message code='messages.specialization'/>:"+item.id+"</p> </div> </div>")
            })

        }
    });
});