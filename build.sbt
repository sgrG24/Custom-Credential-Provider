name := "Custom-Cred-Provider2"

resolvers ++= Seq(
  "Sonatype Release" at "https://oss.sonatype.org/content/repositories/releases"
)

lazy val sparkApp = (project in file("."))
  .settings(
    name := "custom-cred-provider",
    version := "1.0.0-SNAPSHOT",
    scalaVersion := "2.12.11",
    libraryDependencies ++= Seq(hadoop_aws, awsSdkSTS,awsSdkS3, awsSdk)
  )

val awsSDKVersion = "1.11.749"

lazy val awsSdk     = "com.amazonaws" % "aws-java-sdk-core" % awsSDKVersion
lazy val awsSdkS3   = "com.amazonaws" % "aws-java-sdk-s3" % awsSDKVersion
lazy val awsSdkSTS   = "com.amazonaws" % "aws-java-sdk-sts" % awsSDKVersion

val hadoop_aws = "org.apache.hadoop" % "hadoop-aws" % "2.8.5" % "provided" excludeAll {
  ExclusionRule(organization = "com.amazonaws", name = "aws-java-sdk")
}
