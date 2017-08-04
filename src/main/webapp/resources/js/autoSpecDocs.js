/**
 * Created by Admin on 02.08.2017.
 */

    console.log($("#autocomplete-spec").val())
    $("#autocomplete-spec").autocomplete({
        serviceUrl: '/doc/by/spec',
        paramName: "name",
        delimiter: ",",
        transformResult: function (response) {
            console.log("before doc by spec" );
            return {

                suggestions: $.map($.parseJSON(response), function (item) {
                    var i = item.name;
                    console.log(i);
                    return {value: i, data: item.name};
                })
            };
        } });


