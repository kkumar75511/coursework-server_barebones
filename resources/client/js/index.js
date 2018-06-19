function pageLoad() {

    loadMessages();
    resetForm();

}

function loadMessages () {

    let messagesHTML = '';

    $.ajax ({

        url: '/message/list',
        type: 'GET',
        success: messageList => {

            if (messageList.hasOwnProperty('error')) {

                alert(messageList.eror);

            } else {

                for (let message of messageList) {

                    messagesHTML += renderMessage(message);

                }

                $('#messages').html(messagesHTML);

            }

        }

    })

}

function renderMessage (message) {

    return  `<div class="border border-primary p-2 m-2">` +
                `<div>` +
                    `<span class="badge badge-primary mr-2">${message.author}</span>` +
                    `<span class="badge badge-info">${message.postDate}</span>` +
                `</div>` +
                `<div class="py-2 mx-2">${message.text}</div>` +
            `</div>`;

}

function resetForm () {

    const form = $('#messageForm');
    form.unbind("submit");

    form.on("submit", event => {

        event.preventDefault();

        $.ajax ({

            url: '/message/new',
            type: 'POST',
            data: form.serialize(),

            success: reponse => {

                if (reponse === 'OK') {

                    pageLoad();

                } else {

                    alert(reponse);

                }

            }

        })

    })

}