{
   "info": {
      "_postman_id": "",
      "name": "${projectName}",
      "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
   },
   "item": [
      <#list controllerNodes as controller>
      {
         "name": "${controller.description}",
         "item": [
            <#list controller.requestNodes as reqNode>
               {
               "name": "${reqNode.description}",
               "request": {
                  "header": [{
                        "key": "JBOLTAPI",
                        "value": "true",
                        "type": "text"
                     },
                     {
                        "key": "jboltappid",
                        <#if reqNode.url?contains("wxa")>
                           "value": "{{wxa_appid}}",
                        <#else>
                           "value": "{{app_appid}}",
                        </#if>
                        "type": "text"
                     },
                     {
                        "key": "jboltjwt",
                        "value": "{{app_jwt}}",
                        "type": "text"
                     }
                  ],
                  "url": {
                     "raw": "{{domain}}${reqNode.url}",
                     "query": [
                        <#if reqNode.paramNodes?size != 0>
                           <#list reqNode.paramNodes as paramNode>
                              {
                                 "key": "${paramNode.name}",
                                 "value": "",
                                 "description": "${paramNode.description}"
                              }<#if paramNode_has_next>,</#if>
                           </#list>
                        </#if>
                        ]
                     }
                  }
               }<#if reqNode_has_next>,</#if>
            </#list>
         ]
      }<#if controller_has_next>,</#if>
      </#list>
   ]
}