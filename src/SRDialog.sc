;;; Sierra Script 1.0 - (do not remove this comment)
(script# 990)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Print)
(use DIcon)
(use File)

(public
	proc990_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 15]
	[local20 15]
	[local35 15]
	[local50 15]
	[theText 25]
)
(procedure (proc990_0 param1 &tmp temp0 [temp1 33] [temp34 100] [temp134 50])
	(asm
code_0947:
		pushi    #font
		pushi    1
		pushi    0
		pushi    198
		pushi    7
		pushi    1
		pushi    0
		pushi    0
		pushi    1
		pushi    0
		pushi    0
		pushi    990
		pushi    200
		pushi    5
		pushi    2
		lea      @temp1
		push    
		lsp      param1
		callk    StrCpy,  4
		push    
		pushi    29
		pushi    0
		pushi    20
		lsp      param1
		pushi    205
		pushi    8
		pushi    1
		pushi    27
		pushi    0
		pushi    0
		pushi    1
		pushi    0
		pushi    34
		pushi    990
		pushi    205
		pushi    8
		pushi    0
		pushi    38
		pushi    0
		pushi    0
		pushi    1
		pushi    50
		pushi    34
		pushi    990
		pushi    110
		pushi    0
		class    Print
		send     82
		sat      temp0
		not     
		bnt      code_09a2
		ldi      0
		ret     
code_09a2:
		pushi    1
		lea      @temp1
		push    
		callk    StrLen,  2
		not     
		bnt      code_09b5
		pushi    1
		lea      @temp1
		push    
		callk    GetCWD,  2
code_09b5:
		pushi    1
		lea      @temp1
		push    
		callk    ValidPath,  2
		bnt      code_09cf
		pushi    2
		lsp      param1
		lea      @temp1
		push    
		callk    StrCpy,  4
		ldi      1
		ret     
		jmp      code_0947
code_09cf:
		pushi    7
		pushi    0
		pushi    990
		pushi    29
		pushi    0
		pushi    0
		pushi    1
		lea      @temp134
		push    
		callk    Message,  14
		pushi    3
		lea      @temp34
		push    
		lea      @temp134
		push    
		lea      @temp1
		push    
		callk    Format,  6
		pushi    #font
		pushi    1
		pushi    0
		pushi    198
		pushi    1
		lea      @temp34
		push    
		pushi    110
		pushi    0
		class    Print
		send     16
		jmp      code_0947
		ret     
	)
)

(procedure (localproc_0743)
	(return
		(cond 
			((== self Restore) 0)
			((localproc_0a09) 1)
			(local2 2)
			(else 3)
		)
	)
)

(procedure (localproc_0a09)
	(if (< local2 20) (CheckFreeSpace global29))
)

(procedure (localproc_0a17)
	(Print font: 0 addText: 3 0 0 1 0 0 990 init:)
)

(class SRDialog of Dialog
	(properties
		elements 0
		size 0
		text 0
		font 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		caller 0
		seconds 0
		lastSeconds 0
		eatTheMice 0
		lastTicks 0
	)
	
	(method (init param1 param2 param3 &tmp [temp0 250])
		(= window gEcoWin)
		(= nsBottom 0)
		(if
			(==
				(= local2 (GetSaveFiles (gGame name?) param2 param3))
				-1
			)
			(return 0)
		)
		(if (== (= local4 (localproc_0743)) 1)
			(editI
				text: (StrCpy param1 param2)
				font: global23
				setSize:
				moveTo: 4 4
			)
			(self add: editI setSize:)
		)
		(selectorI
			text: param2
			font: global23
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state: 2
		)
		(switch local4
			(0
				(Message msgGET 990 26 0 0 1 @local5)
			)
			(1
				(Message msgGET 990 28 0 0 1 @local5)
			)
			(else 
				(Message msgGET 990 25 0 0 1 @local5)
			)
		)
		(= local1 (+ (selectorI nsRight?) 4))
		(okI
			text: @local5
			setSize:
			moveTo: local1 (selectorI nsTop?)
			state:
				(if
				(or (and (== local4 0) (not local2)) (== local4 3))
					0
				else
					3
				)
		)
		(Message msgGET 990 24 0 0 1 @local20)
		(deleteI
			text: @local20
			setSize:
			moveTo: local1 (+ (okI nsBottom?) 4)
			state: (if (not local2) 0 else 3)
		)
		(Message msgGET 990 23 0 0 1 @local35)
		(changeDirI
			text: @local35
			setSize:
			moveTo: local1 (+ (deleteI nsBottom?) 4)
			state: (& (changeDirI state?) $fff7)
		)
		(Message msgGET 990 22 0 0 1 @local50)
		(cancelI
			text: @local50
			setSize:
			moveTo: local1 (+ (changeDirI nsBottom?) 4)
			state: (& (cancelI state?) $fff7)
		)
		(self
			add: selectorI okI deleteI changeDirI cancelI
			setSize:
		)
		(switch local4
			(0
				(Message msgGET 990 10 0 0 1 @temp0)
			)
			(1
				(Message msgGET 990 11 0 0 1 @temp0)
			)
			(else 
				(Message msgGET 990 30 0 0 1 @temp0)
			)
		)
		(textI
			text: @temp0
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local1 (+ (textI nsBottom?) 4))
		(self eachElementDo: #move 0 local1)
		(self add: textI setSize: center: open: 4 -1)
		(return 1)
	)
	
	(method (doit param1 &tmp temp0 temp1 temp2 [temp3 361] [temp364 21] [temp385 140])
		(asm
			pushSelf
			class    Restore
			eq?     
			bnt      code_03eb
			lap      argc
			bnt      code_03eb
			lap      param1
			bnt      code_03eb
			pushi    2
			pushi    0
			pushi    3
			lea      @temp385
			push    
			lofsa    {%ssg.dir}
			push    
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			callk    Format,  6
			push    
			callk    FileIO,  4
			sat      temp0
			push    
			ldi      65535
			eq?     
			bnt      code_03e4
			ret     
code_03e4:
			pushi    2
			pushi    1
			lst      temp0
			callk    FileIO,  4
code_03eb:
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			not     
			bnt      code_0403
			ldi      65535
			ret     
code_0403:
			lsl      local4
			dup     
			ldi      0
			eq?     
			bnt      code_0419
			lal      local2
			bnt      code_0414
			lofsa    okI
			jmp      code_0432
code_0414:
			lofsa    changeDirI
			jmp      code_0432
code_0419:
			dup     
			ldi      1
			eq?     
			bnt      code_0424
			lofsa    editI
			jmp      code_0432
code_0424:
			dup     
			ldi      2
			eq?     
			bnt      code_042f
			lofsa    okI
			jmp      code_0432
code_042f:
			lofsa    changeDirI
code_0432:
			toss    
			sal      local0
			pushi    #doit
			pushi    1
			push    
			super    Dialog,  6
			sal      local1
			pushi    #indexOf
			pushi    1
			pushi    #cursor
			pushi    0
			lofsa    selectorI
			send     4
			push    
			lofsa    selectorI
			send     6
			sal      local3
			push    
			ldi      18
			mul     
			sat      temp2
			lsl      local1
			lofsa    changeDirI
			eq?     
			bnt      code_04a9
			pushi    #dispose
			pushi    0
			self     4
			pushi    1
			lsg      global29
			call     proc990_0,  2
			bnt      code_0494
			pushi    3
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			lea      @temp3
			push    
			lea      @temp364
			push    
			callk    GetSaveFiles,  6
			sal      local2
			push    
			ldi      65535
			eq?     
			bnt      code_0494
			ldi      65535
			sat      temp1
			jmp      code_072d
code_0494:
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0403
code_04a9:
			lsl      local4
			ldi      2
			eq?     
			bnt      code_04f3
			lsl      local1
			lofsa    okI
			eq?     
			bnt      code_04f3
			pushi    #dispose
			pushi    0
			self     4
			pushi    #doit
			pushi    1
			pushi    2
			lsp      param1
			lat      temp2
			leai     @temp3
			push    
			callk    StrCpy,  4
			push    
			lofsa    GetReplaceName
			send     6
			bnt      code_04de
			lal      local3
			lati     temp364
			sat      temp1
			jmp      code_072d
code_04de:
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0403
code_04f3:
			lsl      local4
			ldi      1
			eq?     
			bnt      code_05b4
			lsl      local1
			lofsa    okI
			eq?     
			bt       code_050c
			lsl      local1
			lofsa    editI
			eq?     
			bnt      code_05b4
code_050c:
			pushi    1
			lsp      param1
			callk    StrLen,  2
			push    
			ldi      0
			eq?     
			bnt      code_0537
			pushi    #dispose
			pushi    0
			self     4
			pushi    0
			call     localproc_0a17,  0
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0403
code_0537:
			ldi      65535
			sat      temp1
			ldi      0
			sal      local1
code_053f:
			lsl      local1
			lal      local2
			lt?     
			bnt      code_055e
			pushi    2
			lsp      param1
			lsl      local1
			ldi      18
			mul     
			leai     @temp3
			push    
			callk    StrCmp,  4
			sat      temp1
			not     
			bnt      code_055a
code_055a:
			+al      local1
			jmp      code_053f
code_055e:
			lat      temp1
			not     
			bnt      code_056d
			lal      local1
			lati     temp364
			sat      temp1
			jmp      code_072d
code_056d:
			lsl      local2
			ldi      20
			eq?     
			bnt      code_057e
			lal      local3
			lati     temp364
			sat      temp1
			jmp      code_072d
code_057e:
			ldi      0
			sat      temp1
code_0582:
			ldi      1
			bnt      code_072d
			ldi      0
			sal      local1
code_058b:
			lsl      local1
			lal      local2
			lt?     
			bnt      code_05a0
			lst      temp1
			lal      local1
			lati     temp364
			eq?     
			bnt      code_059c
code_059c:
			+al      local1
			jmp      code_058b
code_05a0:
			lsl      local1
			lal      local2
			eq?     
			bnt      code_05aa
			jmp      code_072d
code_05aa:
			+at      temp1
			jmp      code_0582
			jmp      code_072d
			jmp      code_0403
code_05b4:
			lsl      local1
			lofsa    deleteI
			eq?     
			bnt      code_06d9
			pushi    #dispose
			pushi    0
			self     4
			pushi    #addText
			pushi    7
			pushi    12
			pushi    0
			pushi    0
			pushi    1
			pushi    0
			pushi    0
			pushi    990
			pushi    205
			pushi    8
			pushi    0
			pushi    31
			pushi    0
			pushi    0
			pushi    1
			pushi    0
			pushi    35
			pushi    990
			pushi    205
			pushi    8
			pushi    1
			pushi    32
			pushi    0
			pushi    0
			pushi    1
			pushi    50
			pushi    35
			pushi    990
			pushi    110
			pushi    0
			class    Print
			send     62
			not     
			bnt      code_0613
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0403
code_0613:
			pushi    #name
			pushi    1
			pushi    3
			pushi    7
			lea      @temp385
			push    
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			callk    DeviceInfo,  6
			push    
			pushi    189
			pushi    1
			pushi    2
			pushi    #new
			pushi    0
			class    File
			send     4
			sat      temp0
			send     12
			ldi      2570
			sat      temp1
			ldi      0
			sal      local1
code_0645:
			lsl      local1
			lal      local2
			lt?     
			bnt      code_0686
			lsl      local1
			lal      local3
			ne?     
			bnt      code_0682
			pushi    #write
			pushi    2
			lal      local1
			leai     @temp364
			push    
			pushi    2
			lat      temp0
			send     8
			pushi    331
			pushi    #x
			lsl      local1
			ldi      18
			mul     
			leai     @temp3
			push    
			lat      temp0
			send     6
			pushi    #write
			pushi    2
			lea      @temp1
			push    
			pushi    1
			lat      temp0
			send     8
code_0682:
			+al      local1
			jmp      code_0645
code_0686:
			ldi      65535
			sat      temp1
			pushi    #write
			pushi    2
			lea      @temp1
			push    
			pushi    2
			pushi    335
			pushi    0
			pushi    111
			pushi    0
			lat      temp0
			send     16
			pushi    4
			pushi    8
			lea      @temp385
			push    
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			lal      local3
			lsti     temp364
			callk    DeviceInfo,  8
			pushi    2
			pushi    4
			lea      @temp385
			push    
			callk    FileIO,  4
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0403
code_06d9:
			lsl      local1
			lofsa    okI
			eq?     
			bnt      code_06ed
			lal      local3
			lati     temp364
			sat      temp1
			jmp      code_072d
			jmp      code_0403
code_06ed:
			lsl      local1
			ldi      65535
			eq?     
			bt       code_06fc
			lsl      local1
			lofsa    cancelI
			eq?     
			bnt      code_0705
code_06fc:
			ldi      65535
			sat      temp1
			jmp      code_072d
			jmp      code_0403
code_0705:
			lsl      local4
			ldi      1
			eq?     
			bnt      code_0403
			pushi    #cursor
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lat      temp2
			leai     @temp3
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    80
			pushi    0
			lofsa    editI
			send     10
			jmp      code_0403
code_072d:
			pushi    1
			pushi    993
			callk    DisposeScript,  2
			pushi    #dispose
			pushi    0
			self     4
			pushi    1
			pushi    990
			callk    DisposeScript,  2
			lat      temp1
			ret     
		)
	)
	
	(method (dispose)
		(super dispose: &rest)
	)
)

(class Restore of SRDialog
	(properties
		elements 0
		size 0
		text 0
		font 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		caller 0
		seconds 0
		lastSeconds 0
		eatTheMice 0
		lastTicks 0
	)
	
	(method (init)
		(Message msgGET 990 20 0 0 1 @theText)
		(= text @theText)
		(super init: &rest)
	)
)

(class Save of SRDialog
	(properties
		elements 0
		size 0
		text 0
		font 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		caller 0
		seconds 0
		lastSeconds 0
		eatTheMice 0
		lastTicks 0
	)
	
	(method (init)
		(Message msgGET 990 21 0 0 1 @theText)
		(= text @theText)
		(super init: &rest)
	)
)

(instance GetReplaceName of Dialog
	(properties)
	
	(method (doit param1 &tmp temp0 [temp1 15] [temp16 15] [temp31 15] [temp46 15])
		(= window gEcoWin)
		(Message msgGET 990 33 0 0 1 @temp1)
		(text1 text: @temp1 setSize: moveTo: 4 4)
		(self add: text1 setSize:)
		(oldName
			text: param1
			font: global23
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: oldName setSize:)
		(Message msgGET 990 34 0 0 1 @temp16)
		(text2 text: @temp16 setSize: moveTo: 4 nsBottom)
		(self add: text2 setSize:)
		(newName
			text: param1
			font: global23
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: newName setSize:)
		(Message msgGET 990 33 0 0 1 @temp31)
		(button1 text: @temp31 nsLeft: 0 nsTop: 0 setSize:)
		(Message msgGET 990 38 0 0 1 @temp46)
		(button2 text: @temp46 nsLeft: 0 nsTop: 0 setSize:)
		(button2
			moveTo: (- nsRight (+ (button2 nsRight?) 4)) nsBottom
		)
		(button1
			moveTo: (- (button2 nsLeft?) (+ (button1 nsRight?) 4)) nsBottom
		)
		(self add: button1 button2 setSize: center: open: 0 -1)
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen param1))
			(localproc_0a17)
			(= temp0 0)
		)
		(return (if (== temp0 newName) else (== temp0 button1)))
	)
)

(instance selectorI of DSelector
	(properties
		x 36
		y 8
	)
)

(instance editI of DEdit
	(properties
		max 35
	)
)

(instance okI of DButton
	(properties)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance cancelI of DButton
	(properties)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance changeDirI of DButton
	(properties)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance deleteI of DButton
	(properties)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance textI of DText
	(properties
		font 0
	)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance text1 of DText
	(properties
		font 0
	)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance text2 of DText
	(properties
		font 0
	)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance oldName of DText
	(properties)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance newName of DEdit
	(properties
		max 35
	)
)

(instance button1 of DButton
	(properties)
	
	(method (dispose)
		(super dispose: 1)
	)
)

(instance button2 of DButton
	(properties)
	
	(method (dispose)
		(super dispose: 1)
	)
)
