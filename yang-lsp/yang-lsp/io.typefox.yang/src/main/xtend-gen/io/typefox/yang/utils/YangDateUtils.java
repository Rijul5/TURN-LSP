package io.typefox.yang.utils;

import io.typefox.yang.yang.Revision;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Utilities for dates in YANG.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public abstract class YangDateUtils {
  private static final class DateFormatThreadLocal extends ThreadLocal<SimpleDateFormat> {
    private final SimpleDateFormat delegate;
    
    public DateFormatThreadLocal(final String pattern) {
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(pattern);
      this.delegate = _simpleDateFormat;
      this.delegate.setLenient(false);
    }
    
    @Override
    public SimpleDateFormat get() {
      return this.delegate;
    }
    
    @Override
    public void set(final SimpleDateFormat value) {
    }
  }
  
  /**
   * The YANG revision format.
   * <br>
   * From RFC-7950: {@code YYYY-MM-DD}.
   * <br>
   * Corresponding JAVA representation: {@code yyyy-MM-dd}.
   * <p>
   * See: https://tools.ietf.org/html/rfc7950#section-7.1.9
   */
  public static final String REVISION_FORMAT = "yyyy-MM-dd";
  
  /**
   * The thread safe date format for the revision date.
   */
  private static final YangDateUtils.DateFormatThreadLocal REVISION_DATE_FORMAT = new YangDateUtils.DateFormatThreadLocal(YangDateUtils.REVISION_FORMAT);
  
  /**
   * Null-safe revision comparator that does not compare the revisions at all if
   * the dates cannot be interpreted and/or parsed.
   */
  private static final Comparator<Revision> REVISION_DATE_COMPARATOR = new Function0<Comparator<Revision>>() {
    public Comparator<Revision> apply() {
      abstract class __YangDateUtils_1 implements Comparator<Revision> {
        abstract long getTimeSafe(final Revision it);
      }
      
      __YangDateUtils_1 ___YangDateUtils_1 = new __YangDateUtils_1() {
        @Override
        public int compare(final Revision left, final Revision right) {
          final long leftTime = this.getTimeSafe(left);
          final long rightTime = this.getTimeSafe(right);
          if (((leftTime == (-1L)) || (rightTime == (-1L)))) {
            return 0;
          }
          return Long.compare(leftTime, rightTime);
        }
        
        long getTimeSafe(final Revision it) {
          if (((it == null) || StringExtensions.isNullOrEmpty(it.getRevision()))) {
            return (-1L);
          }
          try {
            return YangDateUtils.getRevisionDateFormat().parse(it.getRevision()).getTime();
          } catch (final Throwable _t) {
            if (_t instanceof ParseException) {
              return (-1L);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      };
      return ___YangDateUtils_1;
    }
  }.apply();
  
  /**
   * Returns with {@code true} if the first revision argument is
   * chronological strictly greater than the second argument.
   * If any of the arguments is {@code null}, or the date information is
   * not available (or invalid) for any of the arguments, this method returns {@code false}.
   */
  public static boolean isGreaterThan(final Revision left, final Revision right) {
    int _compare = YangDateUtils.REVISION_DATE_COMPARATOR.compare(left, right);
    return (_compare > 0);
  }
  
  /**
   * Returns with the date format for YANG revisions.
   */
  public static SimpleDateFormat getRevisionDateFormat() {
    return YangDateUtils.REVISION_DATE_FORMAT.get();
  }
  
  private YangDateUtils() {
  }
}
