/**
 * Created by Admin on 23.08.2017.
 */
(function($) {
    $(document).ready(function() {
        var $chatbox = $('.chatbox'),
            $chatboxTitle = $('.chatbox__title'),
            $chatboxTitleClose = $('.chatbox__title__close'),
            $chatboxCredentials = $('.chatbox__credentials');
        $chatboxTitle.on('click', function(e) {
            console.log("in")
            connect();
            $chatbox.toggleClass('chatbox--tray');

            $chatbox.removeClass('chatbox--empty');
        });
        $chatboxTitleClose.on('click', function(e) {
            console.log("ddddddddddddddddddddddddddddddddddddddddddddddddddddd")

            $chatbox.addClass('chatbox--closed');
        });
        $chatbox.on('transitionend', function() {
            if ($chatbox.hasClass('chatbox--closed')) disconnect();
        });
        $chatboxCredentials.on('submit', function(e) {
            e.preventDefault();
            $chatbox.removeClass('chatbox--empty');
        });
    });
})(jQuery);


var stompClient = null;

function setConnected(connected) {
//            document.getElementById('connect').disabled = connected;
//            document.getElementById('disconnect').disabled = !connected;
//            document.getElementById('conversationDiv').style.visibility
//                = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}

function connect() {

    if(stompClient==null){
    var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        console.log("hell")
        stompClient.subscribe('/topic/messages', function (messageOutput) {
            console.log("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhssssssssssssssss")
            showMessageOutput(JSON.parse(messageOutput.body));
        });

    });}
}

function disconnect() {
    if(stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
//            var from = document.getElementById('from').value;
    console.log("hereerererer")
    var text = document.getElementById('text').value;
    stompClient.send("/app/chat", {},
        JSON.stringify({  'text':text}));
    console.log("before")
    $("textarea").val("")
}

function showMessageOutput(messageOutput) {
    console.log("rrrrfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(messageOutput.from + ": "+
       " (" + messageOutput.date + ")" + messageOutput.text ));
    response.appendChild(p);
}