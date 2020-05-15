import requests

url = "https://alexnormand-dino-ipsum.p.rapidapi.com/"

querystring = {"format":"html","words":"30","paragraphs":"30"}

headers = {
    'x-rapidapi-host': "alexnormand-dino-ipsum.p.rapidapi.com",
    'x-rapidapi-key': "nope"
    }

response = requests.request("GET", url, headers=headers, params=querystring)

print(response.text)
