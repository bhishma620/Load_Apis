# Implentation of below Api's

## Base URL
```
http://localhost:8080
```

## 1. POST `/load`

### Description
Create a new load entry.

### Request Payload
```json
{
	"loadingPoint": "delhi",
	"unloadingPoint": "jaipur",
	"productType": "chemicals",
	"truckType": "canter",
	"noOfTrucks": "1",
	"weight": "100",
	"comment": "",
	"shipperId": "shipper:<UUID>",
	"date": "dd-mm-yyyy"
}
```

### Response
- Status: 200 OK
- Body: "Load details added successfully"

## 2. GET `/load`

### Description
Get a list of loads associated with a specific shipper.

### Query Parameters
- `shipperId`: The ID of the shipper

### Response
- Status: 200 OK
- Body: List of loads with the specified shipperId

## 3. GET `/load/{loadId}`

### Description
Retrieve details of a specific load.

### Path Parameters
- `loadId`: The ID of the load

### Response
- Status: 200 OK
- Body: Details of the specified load

## 4. PUT `/load/{loadId}`

### Description
Update details of a specific load.

### Path Parameters
- `loadId`: The ID of the load

### Request Payload
```json
{
	"loadingPoint": "alwar",
	"unloadingPoint": "jaipur",
	"productType": "chemicals",
	"truckType": "canter",
	"noOfTrucks": "1",
	"weight": "100",
	"comment": "",
	"date": "dd-mm-yyyy"
}
```

### Response
- Status: 200 OK
- Body: "Load details updated successfully"

## 5. DELETE `/load/{loadId}`

### Description
Delete a specific load.

### Path Parameters
- `loadId`: The ID of the load

### Response
- Status: 200 OK
- Body: "Load deleted successfully"

Note: Replace `<UUID>` with the actual UUID of the shipper.
