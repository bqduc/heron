package net.brilliant.exceptions;

import java.text.MessageFormat;

import org.springframework.security.core.AuthenticationException;

import net.brilliant.ccs.exceptions.EcosExceptionCode;

/**
 * The class {@code EcosphereAuthException} and its subclasses are a form of
 * {@code Throwable} that indicates conditions that a reasonable
 * application might want to catch.
 *
 * <p>The class {@code EcosphereAuthException} and any subclasses that are not also
 * subclasses of {@link RuntimeException} are <em>checked
 * exceptions</em>.  Checked exceptions need to be declared in a
 * method or constructor's {@code throws} clause if they can be thrown
 * by the execution of the method or constructor and propagate outside
 * the method or constructor boundary.
 *
 * @author bqduc
 */
public class NgepAuthException extends RuntimeException/*AuthenticationException*/ {
	private static final long serialVersionUID = 2027543779433269666L;

	private EcosExceptionCode authCode;
	/**
   * Constructs a new exception with {@code null} as its detail message.
   * The cause is not initialized, and may subsequently be initialized by a
   * call to {@link #initCause}.
   */
  public NgepAuthException() {
      super("Default exception!");
  }

	/**
   * Constructs a new exception with {@code null} as its detail message.
   * The cause is not initialized, and may subsequently be initialized by a
   * call to {@link #initCause}.
   */
  public NgepAuthException(EcosExceptionCode authCode) {
  	super(MessageFormat.format("Default exception with error code: {0}", authCode.name()));
  	this.authCode = authCode;
  }

  /**
   * Constructs a new exception with the specified detail message.  The
   * cause is not initialized, and may subsequently be initialized by
   * a call to {@link #initCause}.
   *
   * @param   message   the detail message. The detail message is saved for
   *          later retrieval by the {@link #getMessage()} method.
   */
  public NgepAuthException(String message) {
      super(message);
  }

  /**
   * Constructs a new exception with the specified detail message.  The
   * cause is not initialized, and may subsequently be initialized by
   * a call to {@link #initCause}.
   *
   * @param   message   the detail message. The detail message is saved for
   *          later retrieval by the {@link #getMessage()} method.
   */
  public NgepAuthException(EcosExceptionCode authenticationCode, String message) {
      super(message);
    	this.authCode = authenticationCode;
  }

  /**
   * Constructs a new exception with the specified detail message and
   * cause.  <p>Note that the detail message associated with
   * {@code cause} is <i>not</i> automatically incorporated in
   * this exception's detail message.
   *
   * @param  message the detail message (which is saved for later retrieval
   *         by the {@link #getMessage()} method).
   * @param  cause the cause (which is saved for later retrieval by the
   *         {@link #getCause()} method).  (A <tt>null</tt> value is
   *         permitted, and indicates that the cause is nonexistent or
   *         unknown.)
   * @since  1.4
   */
  public NgepAuthException(String message, Throwable cause) {
      super(message, cause);
  }

  /**
   * Constructs a new exception with the specified cause and a detail
   * message of <tt>(cause==null ? null : cause.toString())</tt> (which
   * typically contains the class and detail message of <tt>cause</tt>).
   * This constructor is useful for exceptions that are little more than
   * wrappers for other throwables (for example, {@link
   * java.security.PrivilegedActionException}).
   *
   * @param  cause the cause (which is saved for later retrieval by the
   *         {@link #getCause()} method).  (A <tt>null</tt> value is
   *         permitted, and indicates that the cause is nonexistent or
   *         unknown.)
   * @since  1.4
   */
  public NgepAuthException(Throwable cause) {
      super("", cause);
  }

  /**
   * Constructs a new exception with the specified detail message,
   * cause, suppression enabled or disabled, and writable stack
   * trace enabled or disabled.
   *
   * @param  message the detail message.
   * @param cause the cause.  (A {@code null} value is permitted,
   * and indicates that the cause is nonexistent or unknown.)
   * @param enableSuppression whether or not suppression is enabled
   *                          or disabled
   * @param writableStackTrace whether or not the stack trace should
   *                           be writable
   * @since 1.7
   */
  protected NgepAuthException(String message, Throwable cause,
                      boolean enableSuppression,
                      boolean writableStackTrace) {
      //super(message, cause, enableSuppression, writableStackTrace);
  	super(message, cause);
  }

	public EcosExceptionCode getAuthenticationCode() {
		return authCode;
	}

	public void setAuthenticationCode(EcosExceptionCode authenticationCode) {
		this.authCode = authenticationCode;
	}
}
