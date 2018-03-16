//*****************************************************************************
//
// File Name       :  WeiXinException.java
// Date Created    :  2013-12-30
// Last Changed By :  $Author: $
// Last Changed On :  $Date: $
// Revision        :  $Rev: $
// Description     :  TODO To fill in a brief description of the purpose of
//                    this class.
//
// Cloudycd Pte Ltd.  Copyright (c) 2013.  All Rights Reserved.
//
//*****************************************************************************

package com.xt.weixinapi.exception;

/**
 * 此类只要定义微信异常
 * 
 * @author GUJUN
 */
public class WeiXinException extends Exception
{
    private static final long serialVersionUID = -6120257414123423785L;


    public WeiXinException()
    {
        super();
    }


    public WeiXinException(String message)
    {
        super(message);
    }


    public WeiXinException(Throwable cause)
    {
        super(cause);
    }


    public WeiXinException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
