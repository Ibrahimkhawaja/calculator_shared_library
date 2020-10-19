def call(body){

    node {
        try{
            config = readYaml text: libraryResource("config.yaml")
    
            config.jobs.collect { jobname ->
                println "jobname.key " + element.key
                println "buildDIR.value " + element.BUILD_DIRECTORY.value
            }
            println "config " + config
            sh "echo ${config}"
        }
        catch(Exception ex){
            sh "echo cannot read yaml"
        }
    }

}