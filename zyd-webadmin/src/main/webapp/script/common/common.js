function changeToURL(url_)
{
    window.location.href = url_;
}


function submitForm(formName, actionURL)
{
	try
	{
		var form = document.getElementById(formName);
		form.action = actionURL;
		form.submit();
	}
	catch(e)
	{
		return;
	}
}


function submitFormInNewWindow(formName, actionURL)
{
	try
	{
		var form = document.getElementById(formName);
		form.action = actionURL;
		form.target = "_blank";
		form.submit();
	}
	catch(e)
	{
		return;
	}
}

function trimForm(_form)
{ 
	if (typeof(_form) != "object") return false;

    for (var i=0; i<_form.elements.length; i++) 
	{
		var el = _form.elements[i];
		if (el.type == 'text') 
		{
			el.value = trimValue(el.value);
		}
    }
    
	return true;
}

function trimValue(value)
{
    if (!value){
        return "";
    }
        
    if (typeof value != "string") { 
    	return value; 
    }
        
    var start = 0;
    var end = value.length;

    while (start < end && value.substring(start, start+1) == " ")
    {
        start++;
    }
    
    while (start < end && value.substring(end-1, end) == " ")
    {
        end--;
    }
    
    return value.substring(start, end);	
}