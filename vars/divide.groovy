def call(body) {
    
    def res = new Divider().Divide(4,2)

    echo "$res"
    currentBuild.result = 'SUCCESS' //FAILURE to fail

    return this
}