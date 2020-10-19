def call(body) {
    
    def res = new Subtracter().Subtract(4,2)

    echo "$res"
    currentBuild.result = 'SUCCESS' //FAILURE to fail

    return this
}