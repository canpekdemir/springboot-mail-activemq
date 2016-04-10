# springboot-mail-activemq

This is a sample mail rest api project which uses spring boot and activemq.
You can change mail smtp configurations from application.yml file.


# Usage

You can post the sample json request to the url: http://localhost:8080/mail

    {
	     "sender": "canpekdemir@yandex.com",
	      "replyTo": "canpekdemir1912@gmail.com",
	      "toList": ["canpekdmr@gmail.com", "can.pekdemir@iyzico.com", "canpekdemir@yandex.com"],
	      "subject": "spring boot rest api with activemq",
	      "body": "<html><head><title>Page Title</title></head><body><h1>This is a Heading</h1><p>This is a paragraph.</p></body></html>"
    }        
