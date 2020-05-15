
from twilio.rest import Client

account_sid = 'ACd007a8c6392b9cee42065e862ef61455'
auth_token = '039e803c77c926d729197ddf5980aaee'
client = Client(account_sid, auth_token)

message = client.messages.create(
        body="Join Earth's mightiest heroes. Like Kevin Bacon.",
        from_='+15342203741',
        to='+16472192778'
        )

print(message.sid)
