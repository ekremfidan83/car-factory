
# CarFactory Api-Service

The CarFactory project is a sample project that responds to you according to the entered car type.

# Installation

To run the car-factory project, you must first build maven. You can use Intellij Idea.

## API Usage

#### getCarType

```http
  GET /api/v1/car-factory/car-type
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `carType` | `string` | **Required**. the field where the car type is sent.
 |

## Deployment

This project is published on port 8080. To change the port, in the application.properties file
```bash
  server.port= <newPort>
```
change the command  
## Feedback

If you have any feedback, please contact us at fidan.ekrem83@hotmail.com
  
