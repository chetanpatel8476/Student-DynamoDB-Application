// Added Shared Library
library identifier: 'cicdjenkins@master', retriever: modernSCM(
    [$class: 'GitSCMSource',
    remote: 'https://github.com/chetanpatel8476/jenkins-shared-library.git',
    //credentialsId: 'svc.devops-ut'
    ]
)

environment {
    AWS_ACCESS_KEY_ID = credentials('access_key_id')
    AWS_SECRET_ACCESS_KEY = credentials('secret_key_id')       
}

buildStudentApp (
    RepoURL : 'https://github.com/chetanpatel8476/Student-DynamoDB-Application.git',
    Access_Key_ID : env.AWS_ACCESS_KEY_ID
    Secret_Key_ID : env.AWS_SECRET_ACCESS_KEY
)