# Package Structure #

##The pacakges##

	vn.edu.hcmut.traffic.tripmaester
	├── model
	└── services
	    └── its


##The short package descriptions ##

	vn.edu.hcmut.traffic.tripmaester : The root package
	├── bussiness	                 : The bussiness rules
    ├── controller                   : The controllers package, which received and dispatched requests
    │   ├── manager	                 : The central managers, 
    │   ├── request	                 : The request builder package
    │   └── response	             : The response of each request
	├── model                        : The models package
    ├── service                      : Services package contains all services being provided to controllers
    │   └── http                     : Connection to ITS server services
    ├── setting                      : Application global settings
    └── ui                           : All ui and related elements
        └── activity                 : The activities


##The full package descriptions ##


Package | Description 
------- | -----------
`vn.edu.hcmut.traffic.tripmaester` | The root package.
`vn.edu.hcmut.traffic.tripmaester.controller` | This package contains the controller center, where is the centralize of gathering all requests in the app. This package also hold interfaces of controllers and request. Note: this is not where a concrete request will be handled. The requests will be delivered to somewhere else (services package) to be done.
`vn.edu.hcmut.traffic.tripmaester.controller.request` | This package contains all requests. Each request has it own Builder pattern. The request will be push into ControllerCenter, and will be dispatched to its own worker.
`vn.edu.hcmut.traffic.tripmaester.model` | This package contains model classes.
`vn.edu.hcmut.traffic.tripmaester.services.its` | This package contains classes which provide connection betwen client and ITS server.