package cn.dreampie.lesscss.compiler;

import org.codehaus.plexus.util.Scanner;
import org.sonatype.plexus.build.incremental.BuildContext;

import java.io.File;

/**
 * Created by wangrenhui on 2014/7/11.
 */
public class AbstractLessCss {

  /**
   * component
   */
  protected BuildContext buildContext;

  /**
   * The source directory containing the LESS sources.
   */
  protected File sourceDirectory;

  /**
   * List of files to include. Specified as fileset patterns which are relative to the source directory. Default value is: { "**\/*.less" }
   */
  protected String[] includes = new String[]{"**/*.less"};

  /**
   * List of files to exclude. Specified as fileset patterns which are relative to the source directory.
   */
  protected String[] excludes = new String[]{};

  /**
   * Scans for the LESS sources that should be compiled.
   * @return The list of LESS sources.
   */
  protected String[] getIncludedFiles() {
    Scanner scanner = buildContext.newScanner(sourceDirectory, true);
    scanner.setIncludes(includes);
    scanner.setExcludes(excludes);
    scanner.scan();
    return scanner.getIncludedFiles();
  }

  /**
   * Whether to skip plugin execution.
   * This makes the build more controllable from profiles.
   */
  protected boolean skip;

  public BuildContext getBuildContext() {
    return buildContext;
  }

  public void setBuildContext(BuildContext buildContext) {
    this.buildContext = buildContext;
  }

  public File getSourceDirectory() {
    return sourceDirectory;
  }

  public void setSourceDirectory(File sourceDirectory) {
    this.sourceDirectory = sourceDirectory;
  }

  public String[] getIncludes() {
    return includes;
  }

  public void setIncludes(String[] includes) {
    this.includes = includes;
  }

  public String[] getExcludes() {
    return excludes;
  }

  public void setExcludes(String[] excludes) {
    this.excludes = excludes;
  }

  public boolean isSkip() {
    return skip;
  }

  public void setSkip(boolean skip) {
    this.skip = skip;
  }
}
