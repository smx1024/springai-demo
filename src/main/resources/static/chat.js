document.getElementById('send-button').addEventListener('click', sendMessage);
document.getElementById('message-input').addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        sendMessage();
    }
});

function sendMessage() {
    const messageInput = document.getElementById('message-input');
    const message = messageInput.value.trim();
    if (message) {
        appendMessageToChatArea('You', message);
        fetch(`http://localhost:8080/test?message=${encodeURIComponent(message)}`, {
            method: 'GET',
        })
            .then(response => appendMessageToChatArea('Bot', response)) // 使用response.text()来获取字符串
            .then(data => {
                appendMessageToChatArea('Bot', data); // 直接使用data作为返回的字符串
            })
            .catch(error => console.error('Error:', error));
        messageInput.value = '';
    }
}

function appendMessageToChatArea(sender, message) {
    const chatArea = document.getElementById('chat-area');
    chatArea.innerHTML += `<p><strong>${sender}:</strong> ${message}</p>`;
    chatArea.scrollTop = chatArea.scrollHeight;
}
