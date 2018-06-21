function pageLoad() {

    loadMessages();
    resetForm();

}

function loadMessages () {

    let messagesHTML = '';

    $("input[name='messageText']").val("");

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

                resetDeleteButtons();

            }

        }

    })

}

function renderMessage (message) {

    return  `<div class="border border-primary p-2 m-2">` +
                `<div>` +
                    `<span class="badge badge-primary mr-2">${message.author}</span>` +
                    `<span class="badge badge-info">${message.postDate}</span>` +
                    `<div class="float-right">` +
                        `<button class="deleteMessage btn btn-sm btn-danger ml-2" data-message-id="${message.id}">` +
                            `Delete` +
                        `</button>` +
                    `</div>` +
                `</div>` +
                `<div class="messageText py-2 mx-2" id=""text${message.id}>${message.text}</div>` +
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

function resetDeleteButtons () {

    $('.deleteMessage').click(event => {

        const messageId = $(event.target).attr('data-message-id');

        $.ajax ({

            url: '/message/delete',
            type: 'POST',
            data: {"messageId" : messageId},

            success: response => {

                if (response === 'OK') {

                    pageLoad();

                } else {

                    alert(response);

                }

            }

        });

    });

}