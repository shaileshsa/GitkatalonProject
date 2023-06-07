const { execSync } = require("child_process");
const projectARN =
  "arn:aws:devicefarm:us-west-2:807608485714:project:4a43c28e-a721-46fb-8598-14743830ffff";

const getSelectedDevicePool = (selectedDevicePool) => {
  const allDevicePools = execSync(
    `aws devicefarm list-device-pools --arn ${projectARN}`
  );
  const devicePoolsParsed = JSON.parse(allDevicePools.toString());
  const devicePools = devicePoolsParsed.devicePools;
  const selectedDevice = devicePools.filter(
    (pool) => pool.name === selectedDevicePool
  );
  return selectedDevice[0].arn;
};

const uploadResource = (name, type) => {
  const result = execSync(
    `aws devicefarm create-upload --project-arn ${projectARN} --name ${name} --type ${type}`
  );
  const parsedResults = JSON.parse(result.toString());
  const curlResults = execSync(`curl -T ${name} "${parsedResults.upload.url}"`);
  console.log(curlResults.toString());
  return parsedResults;
};

const executeRun = () => {
  const arguments = process.argv.slice(2);
  // let devicePool = getSelectedDevicePool(`"${arguments[0]}"`);
  let apkUpload = uploadResource("app_popular_negocios.apk", "ANDROID_APP");
  let testPackageUpload = uploadResource(
    "zip-with-dependencies.zip",
    "APPIUM_JAVA_JUNIT_TEST_PACKAGE"
  );

  setTimeout(() => {
    const scheduleRun = execSync(
      `aws devicefarm schedule-run --project-arn ${projectARN} --name "${arguments[0]}" --app-arn ${apkUpload.upload.arn} --device-pool arn:aws:devicefarm:us-west-2:807608485714:devicepool:4a43c28e-a721-46fb-8598-14743830ffff/0bd9f55b-1faa-4b0a-afad-55c46f2772b3 --test type=APPIUM_JAVA_JUNIT,testPackageArn=${testPackageUpload.upload.arn},testSpecArn=arn:aws:devicefarm:us-west-2::upload:100e31e8-12ac-11e9-ab14-d663b5a4a906`
    );
    console.log(scheduleRun.toString());
  }, 5000);
};

executeRun();
