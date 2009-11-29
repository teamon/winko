desc "create bundles and upload"
task :deploy do
  libdir = "/Applications/Processing.app/Contents/Resources/Java/libraries/opengl/library"
  name = "winko"
  
  platforms = {
    :mac => %w(libgluegen-rt.jnilib libjogl_awt.jnilib libjogl_cg.jnilib libjogl.jnilib),
    :linux => %w(libgluegen-rt.so libjogl_awt.so libjogl_cg.so libjogl.so),
    :windows => %w(gluegen-rt.dll jogl_awt.dll jogl_cg.dll jogl.dll)
  }
  
  Dir.chdir("target")
  FileUtils.rm_r("build") if File.exist?("build")
  Dir.mkdir("build")
  
  platforms.each_pair do |platform, libs|
    dirname = "build/#{name}-#{platform}"
    FileUtils.rm_r(dirname) if File.exist?(dirname)
    Dir.mkdir(dirname)
    
    
    libs.each do |lib|
      FileUtils.cp "#{libdir}/#{lib}", "#{dirname}/#{lib}"
    end
    
    FileUtils.cp "winko-1.0-SNAPSHOT-jar-with-dependencies.jar", "#{dirname}/"
    Dir.chdir("build")
    system("zip -r #{name}-#{platform}.zip #{name}-#{platform}")
    Dir.chdir("..")
    FileUtils.rm_r(dirname)
  end
  
  # system("scp -r build verknowsys.com:~/public_html/winko/")
  # system("cp -r build ~/public_html/winko/")
  

end

