# Erase everything that was in the deploy folder
rm -rf ../deploy/*

# Create a "lib" folder for all of our dependencies
mkdir ../deploy/lib

# Copy over all of the libraries that we use
cp node_modules/bootstrap/dist/css/bootstrap.min.css ../deploy/lib
cp node_modules/bootstrap/dist/js/bootstrap.min.js ../deploy/lib
cp node_modules/jquery/dist/jquery.min.js ../deploy/lib
cp node_modules/handlebars/dist/handlebars.min.js ../deploy/lib

# Copy Bootstrap's fonts
cp -R node_modules/bootstrap/fonts/ ../deploy/

#merge our css files into the deployed .css
cat content.css index.css login.css read.css nav.css welcome.css > ../deploy/web-ravenclaw.css

# Compile our TypeScript int the deployed.js
# Note: it's important that index.ts is last
node_modules/typescript/bin/tsc --outFile ../deploy/web-ravenclaw.js \
    login.ts read.ts content.ts nav.ts welcome.ts index.ts

# Compile our handlebars templates and append them into the deployed js
node_modules/handlebars/bin/handlebars read.hb >> ../deploy/templates.js
node_modules/handlebars/bin/handlebars content.hb >> ../deploy/templates.js
node_modules/handlebars/bin/handlebars nav.hb >> ../deploy/templates.js
node_modules/handlebars/bin/handlebars welcome.hb >> ../deploy/templates.js
node_modules/handlebars/bin/handlebars login.hb >> ../deploy/templates.js

#copy the index.html file and data.json to the deployed position
cp index.html data.json ../deploy

