;;; Sierra Script 1.0 - (do not remove this comment)
(script# 5)
(include sci.sh)
(use Main)
(use n804)
(use n819)
(use EcoFeature)
(use EcoDialog)
(use RTRandCycle)
(use BorderWindow)
(use InvI)
(use Obj)

(public
	invCode 0
)

(instance invCode of Code
	(properties)
	
	(method (init)
		(invWin
			topBordHgt: 5
			botBordHgt: 26
			color: 0
			priority: -1
			back: gBack
			topBordColor: gColor
			lftBordColor: gColor
			rgtBordColor: global216
			botBordColor: global213
			insideColor: global215
			topBordColor2: global213
			lftBordColor2: global216
			botBordColor2: gColor
			rgtBordColor2: gColor
		)
		(Inv
			init:
			add:
				bikeCage
				starFish
				goldMask
				healingPotion
				screws
				waterPump
				tweezers
				urchins
				sharpShell
				conchShell
				sodaCan
				certificate
				card
				beaker
				waterBottle
				frisbee
				mackeral
				scubaGear
				dishSoap
				airTanks
				trident
				spine
				hermetShell
				mirror
				boxKey
				scroll
				sawFishHead
				fishLure
				hackSaw
				transmitter
				float
				steelCable
				jar
				rag
				sixPackRing
			eachElementDo: #highlightColor gInnerBordColor
			eachElementDo: #lowlightColor (invWin insideColor?)
			add: invLook invHand invSelect invHelp ok
			eachElementDo: #init
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
	)
)

(class RInvItem of InvI
	(properties
		view 900
		loop 0
		cel 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		state $0000
		cursor 999
		type $4000
		message 0
		modifiers $0000
		signal $0002
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 0
		helpVerb 0
		owner 0
		script 0
		value 0
		cursorLoop 0
		cursorCel 0
	)
	
	(method (init)
		(= cursor
			(= cursor
				(= cursor
					(= cursor
						(= cursor
							(= cursor
								(= cursor
									(= cursor
										(= cursor
											(= cursor
												(= cursor
													(= cursor
														(= cursor
															(= cursor (= cursor (= cursor (ScriptID 0 7))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(super init: &rest)
	)
	
	(method (select)
		(if (super select: &rest)
			((ScriptID 0 7) cel: cursorCel)
			((ScriptID 0 7) loop: cursorLoop)
		)
	)
	
	(method (doVerb theVerb &tmp theTheVerb temp1 temp2 temp3)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(if (== theVerb 44)
			(= temp1
				(if (== (- theTheVerb 9) (gInv indexOf: self))
					220
				else
					(switch theTheVerb
						(9 10)
						(10 14)
						(11 11)
						(12 27)
						(13 25)
						(14 30)
						(15 32)
						(16 35)
						(17 38)
						(18 28)
						(19 153)
						(20 173)
						(21 171)
						(22 152)
						(23 165)
						(24 160)
						(25 161)
						(26 164)
						(27 154)
						(28 163)
						(29 189)
						(30 193)
						(31 196)
						(32 197)
						(33 198)
						(34 212)
						(35 204)
						(36 205)
						(37 207)
						(38 209)
						(39
							(if (== (float cel?) 6) 203 else 215)
						)
						(40
							(cond 
								((== (steelCable cel?) 11) 206)
								((== (steelCable cel?) 12) 219)
								(else 51)
							)
						)
						(41
							(switch global233
								(0 155)
								(1 156)
								(else  157)
							)
						)
						(42
							(switch global232
								(2 169)
								(0 167)
								(else  6)
							)
						)
						(else  42)
					)
				)
			)
			(= temp3 global251)
			(= global251 1)
			(cond 
				((< temp1 100) (EcoNarrator init: 1 0 0 temp1 0 3))
				((< temp1 200) (EcoNarrator init: 2 0 0 (- temp1 100) 0 4))
				((< temp1 300) (EcoNarrator init: 3 0 0 (- temp1 200) 0 5))
				(else (proc821_2 5 0 temp1))
			)
			(= global251 temp3)
			(= temp3 0)
		else
			(super doVerb: theVerb theTheVerb &rest)
		)
	)
)

(instance sodaCan of RInvItem
	(properties
		message 19
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 67 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 68 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance certificate of RInvItem
	(properties
		cel 1
		message 20
		owner 400
		cursorLoop 1
		cursorCel 10
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 2 0 0 47 0 4)
			)
			(4
				(EcoNarrator init: 2 0 0 72 0 4)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance card of RInvItem
	(properties
		cel 2
		message 21
		cursorLoop 1
		cursorCel 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 2 0 0 46 0 4)
			)
			(4
				(EcoNarrator init: 2 0 0 70 0 4)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beaker of RInvItem
	(properties
		cel 4
		message 22
		owner 400
		cursorCel 1
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4
				(EcoNarrator init: 2 0 0 58 0 4)
			)
			(1
				(if (proc819_5 8)
					(EcoNarrator init: 1 0 0 19 0 3)
				else
					(EcoNarrator init: 3 0 0 13 0 5)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rag of RInvItem
	(properties
		cel 6
		message 42
		owner 400
		cursorCel 2
	)
	
	(method (show)
		(switch global232
			(1
				(= loop
					(= loop
						(= loop
							(= loop
								(= loop
									(= loop
										(= loop
											(= loop
												(= loop
													(= loop
														(= loop
															(= loop (= loop (= loop (= loop (= loop 2)))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cel
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel (= cel (= cel (= cel (= cel (= cel 3))))))
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(2
				(= loop
					(= loop
						(= loop
							(= loop
								(= loop
									(= loop
										(= loop
											(= loop
												(= loop
													(= loop
														(= loop
															(= loop (= loop (= loop (= loop (= loop 0)))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cel
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel (= cel (= cel (= cel (= cel (= cel 11))))))
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(3
				(= loop
					(= loop
						(= loop
							(= loop
								(= loop
									(= loop
										(= loop
											(= loop
												(= loop
													(= loop
														(= loop
															(= loop (= loop (= loop (= loop (= loop 2)))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cel
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel (= cel (= cel (= cel (= cel (= cel 9))))))
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(4
				(= loop
					(= loop
						(= loop
							(= loop
								(= loop
									(= loop
										(= loop
											(= loop
												(= loop
													(= loop
														(= loop
															(= loop (= loop (= loop (= loop (= loop 2)))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cel
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel (= cel (= cel (= cel (= cel (= cel 3))))))
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(else 
				(= loop
					(= loop
						(= loop
							(= loop
								(= loop
									(= loop
										(= loop
											(= loop
												(= loop
													(= loop
														(= loop
															(= loop (= loop (= loop (= loop (= loop 0)))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cel
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel (= cel (= cel (= cel (= cel (= cel 6))))))
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(if (== global232 2)
			(= cursorLoop
				(= cursorLoop
					(= cursorLoop
						(= cursorLoop
							(= cursorLoop
								(= cursorLoop
									(= cursorLoop
										(= cursorLoop
											(= cursorLoop
												(= cursorLoop
													(= cursorLoop
														(= cursorLoop
															(= cursorLoop
																(= cursorLoop (= cursorLoop (= cursorLoop 2)))
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(= cursorCel
				(= cursorCel
					(= cursorCel
						(= cursorCel
							(= cursorCel
								(= cursorCel
									(= cursorCel
										(= cursorCel
											(= cursorCel
												(= cursorCel
													(= cursorCel
														(= cursorCel
															(= cursorCel
																(= cursorCel (= cursorCel (= cursorCel 4)))
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		else
			(= cursorLoop
				(= cursorLoop
					(= cursorLoop
						(= cursorLoop
							(= cursorLoop
								(= cursorLoop
									(= cursorLoop
										(= cursorLoop
											(= cursorLoop
												(= cursorLoop
													(= cursorLoop
														(= cursorLoop
															(= cursorLoop
																(= cursorLoop (= cursorLoop (= cursorLoop 0)))
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(= cursorCel
				(= cursorCel
					(= cursorCel
						(= cursorCel
							(= cursorCel
								(= cursorCel
									(= cursorCel
										(= cursorCel
											(= cursorCel
												(= cursorCel
													(= cursorCel
														(= cursorCel
															(= cursorCel
																(= cursorCel (= cursorCel (= cursorCel 2)))
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(super show: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(switch theVerb
			(1
				(cond 
					(
						(<
							(= temp1
								(switch global232
									(1 3)
									(2 143)
									(3 142)
									(4 3)
									(else  142)
								)
							)
							100
						)
						(EcoNarrator init: 1 0 0 temp1 0 3)
					)
					((< temp1 200) (EcoNarrator init: 2 0 0 (- temp1 100) 0 4))
					((< temp1 300) (EcoNarrator init: 3 0 0 (- temp1 200) 0 5))
				)
			)
			(4
				(switch global232
					(2
						(EcoNarrator init: 2 0 0 68 0 4)
					)
					(0
						(EcoNarrator init: 2 0 0 66 0 4)
					)
					(else 
						(EcoNarrator init: 1 0 0 4 0 3)
					)
				)
			)
			(27
				(if (== global232 0)
					(EcoNarrator init: 2 0 2 15 0 4)
					(Inv hide:)
					(= global232 2)
					(proc0_4 5 202)
					(gEgo put: 18)
					(Inv showSelf: gEgo)
				)
			)
			(31
				(if (proc819_5 273)
					(EcoNarrator init: 2 0 0 41 0 4)
				else
					(EcoNarrator init: 1 0 0 5 0 3)
					(Inv hide:)
					(= global232 4)
					(proc0_4 5 273)
					(Inv showSelf: gEgo)
				)
			)
			(33
				(EcoNarrator init: 1 0 0 57 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dishSoap of RInvItem
	(properties
		cel 7
		message 27
		cursorCel 3
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 2 0 0 44 0 4)
			)
			(4
				(EcoNarrator init: 2 0 0 59 0 4)
			)
			(42
				(proc0_4 5 202)
				(if (== global232 0)
					(EcoNarrator init: 2 0 2 15 0 4)
					(Inv highlightedIcon: rag hide: gEgo)
					(= global232 2)
					(gEgo put: 18)
					(Inv showSelf: gEgo)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frisbee of RInvItem
	(properties
		cel 8
		message 24
		cursorCel 4
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 70 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 71 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mackeral of RInvItem
	(properties
		cel 9
		message 25
		cursorCel 5
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 72 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 73 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scubaGear of RInvItem
	(properties
		loop 2
		message 26
		cursorLoop 3
		cursorCel 6
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 2 0 0 9 0 4)
			)
			(4
				(if (== gNumber 381)
					(EcoNarrator init: 2 0 0 10 0 4)
				else
					(EcoNarrator init: 2 0 0 11 0 4)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance airTanks of RInvItem
	(properties
		loop 2
		cel 1
		message 28
		cursorCel 8
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 78 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 81 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bikeCage of RInvItem
	(properties
		loop 2
		cel 4
		message 9
		owner 180
		cursorCel 9
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(if (proc819_5 298)
					(EcoNarrator init: 1 0 0 15 0 5)
				else
					(EcoNarrator init: 1 0 0 15 0 3)
				)
			)
			(4
				(EcoNarrator init: 1 0 0 13 0 3)
			)
			(13
				(EcoNarrator init: 1 0 1 12 0 3)
				(gEgo put: 4)
				(proc819_3 42)
				(Inv hide:)
				(proc0_4 5 298)
				(Inv showSelf: gEgo)
				(proc0_5 0)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance conchShell of RInvItem
	(properties
		loop 2
		cel 5
		message 18
		owner 140
		cursorCel 10
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 20 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 21 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trident of RInvItem
	(properties
		loop 2
		cel 6
		message 29
		owner 120
		cursorCel 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 16 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 17 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sharpShell of RInvItem
	(properties
		loop 2
		cel 7
		message 17
		owner 222
		cursorCel 12
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 1 1 0 3)
			)
			(4
				(EcoNarrator init: 1 0 1 3 0 3)
			)
			(43
				(EcoNarrator init: 2 0 2 20 0 4)
				(proc0_4 5 289)
				(gEgo put: 34)
				(Inv hide:)
				(gInv showSelf: gEgo)
				(proc0_5 8)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tweezers of RInvItem
	(properties
		loop 2
		cel 8
		message 15
		owner 223
		cursorCel 13
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 31 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 33 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance urchins of RInvItem
	(properties
		loop 4
		message 16
		owner 221
		cursorCel 14
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 34 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 36 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waterPump of RInvItem
	(properties
		loop 4
		cel 1
		message 14
		owner 335
		cursorCel 15
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 29 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 30 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spine of RInvItem
	(properties
		loop 4
		cel 2
		message 30
		owner 226
		cursorLoop 1
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 1 4 0 3)
			)
			(4
				(EcoNarrator init: 1 0 1 5 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screws of RInvItem
	(properties
		loop 4
		cel 3
		message 13
		owner 224
		cursorLoop 1
		cursorCel 1
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 24 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 26 0 3)
			)
			(9
				(EcoNarrator init: 1 0 1 12 0 3)
				(gEgo put: 4 0)
				(proc819_3 42)
				(Inv highlightedIcon: bikeCage hide:)
				(proc0_4 5 298)
				(Inv showSelf: gEgo)
				(proc0_5 0)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goldMask of RInvItem
	(properties
		loop 4
		cel 4
		message 11
		owner 160
		cursorLoop 1
		cursorCel 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 9 0 3)
			)
			(4
				(EcoNarrator init: 2 0 0 94 0 4)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance starFish of RInvItem
	(properties
		loop 4
		cel 5
		message 10
		owner 160
		cursorLoop 1
		cursorCel 3
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 12 0 3)
			)
			(4
				(EcoNarrator init: 2 0 0 95 0 4)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance healingPotion of RInvItem
	(properties
		loop 4
		cel 6
		message 12
		owner 180
		cursorLoop 1
		cursorCel 4
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 22 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 23 0 3)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance hermetShell of RInvItem
	(properties
		loop 4
		cel 8
		message 31
		owner 180
		cursorLoop 1
		cursorCel 6
	)
	
	(method (show)
		(switch global232
			(4
				(= loop
					(= loop
						(= loop
							(= loop
								(= loop
									(= loop
										(= loop
											(= loop
												(= loop
													(= loop
														(= loop
															(= loop (= loop (= loop (= loop (= loop 4)))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cel
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel (= cel (= cel (= cel (= cel (= cel 7))))))
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cursorCel
					(= cursorCel
						(= cursorCel
							(= cursorCel
								(= cursorCel
									(= cursorCel
										(= cursorCel
											(= cursorCel
												(= cursorCel
													(= cursorCel
														(= cursorCel
															(= cursorCel
																(= cursorCel
																	(= cursorCel (= cursorCel (= cursorCel 5)))
																)
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(else 
				(= loop
					(= loop
						(= loop
							(= loop
								(= loop
									(= loop
										(= loop
											(= loop
												(= loop
													(= loop
														(= loop
															(= loop (= loop (= loop (= loop (= loop 4)))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cel
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel (= cel (= cel (= cel (= cel (= cel 8))))))
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(super show: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(if (proc819_5 273)
					(EcoNarrator store: 44 init: 1 0 0 43 0 3)
				else
					(EcoNarrator store: 45 init: 1 0 0 43 0 3)
				)
			)
			(4
				(if (proc819_5 273)
					(EcoNarrator init: 1 0 0 47 0 3)
				else
					(EcoNarrator init: 1 0 0 46 0 3)
				)
			)
			(42
				(if (proc819_5 273)
					(EcoNarrator init: 2 0 0 41 0 4)
				else
					(EcoNarrator init: 1 0 0 5 0 3)
					(Inv hide:)
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel
															(= cel (= cel (= cel (= cel (= cel (= cel 7))))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
					(= global232 4)
					(proc0_4 5 273)
					(Inv showSelf: gEgo)
				)
			)
			(22
				(EcoNarrator init: 1 0 0 19 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance jar of RInvItem
	(properties
		loop 4
		cel 9
		message 41
		owner 420
		cursorLoop 1
		cursorCel 7
	)
	
	(method (show)
		(switch global233
			(1
				(= loop
					(= loop
						(= loop
							(= loop
								(= loop
									(= loop
										(= loop
											(= loop
												(= loop
													(= loop
														(= loop
															(= loop (= loop (= loop (= loop (= loop 4)))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cel
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel (= cel (= cel (= cel (= cel (= cel 11))))))
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cursorCel
					(= cursorCel
						(= cursorCel
							(= cursorCel
								(= cursorCel
									(= cursorCel
										(= cursorCel
											(= cursorCel
												(= cursorCel
													(= cursorCel
														(= cursorCel
															(= cursorCel
																(= cursorCel
																	(= cursorCel (= cursorCel (= cursorCel 8)))
																)
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(2
				(= loop
					(= loop
						(= loop
							(= loop
								(= loop
									(= loop
										(= loop
											(= loop
												(= loop
													(= loop
														(= loop
															(= loop (= loop (= loop (= loop (= loop 6)))))
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cel
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel (= cel (= cel (= cel (= cel (= cel 1))))))
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(= cursorCel
					(= cursorCel
						(= cursorCel
							(= cursorCel
								(= cursorCel
									(= cursorCel
										(= cursorCel
											(= cursorCel
												(= cursorCel
													(= cursorCel
														(= cursorCel
															(= cursorCel
																(= cursorCel
																	(= cursorCel (= cursorCel (= cursorCel 9)))
																)
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(super show: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(switch global233
					(1
						(EcoNarrator init: 1 0 1 22 0 3)
					)
					(2
						(if (== gNumber 540)
							(EcoNarrator init: 3 0 0 45 0 5)
						else
							(EcoNarrator init: 1 0 0 60 0 3)
						)
					)
					(else 
						(EcoNarrator init: 1 0 1 25 0 3)
					)
				)
			)
			(4
				(switch global233
					(0
						(EcoNarrator init: 1 0 1 30 0 3)
					)
					(2
						(if (== gNumber 540)
							(Inv hide:)
							(global2 notify:)
						else
							(EcoNarrator init: 3 0 0 14 0 5)
						)
					)
					(else 
						(EcoNarrator init: 1 0 1 26 0 3)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mirror of RInvItem
	(properties
		loop 6
		cel 2
		message 32
		owner 420
		cursorLoop 1
		cursorCel 13
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 85 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 86 0 3)
			)
			(else 
				(super doVerb: theVerb temp0)
			)
		)
	)
)

(instance boxKey of RInvItem
	(properties
		loop 6
		cel 4
		message 33
		owner 460
		cursorLoop 1
		cursorCel 14
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 89 0 3)
			)
			(42
				(EcoNarrator init: 1 0 0 57 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 90 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance steelCable of RInvItem
	(properties
		loop 6
		cel 5
		message 40
		owner 480
		cursorLoop 1
		cursorCel 15
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(switch cel
					(11
						(EcoNarrator init: 3 0 0 1 0 5)
					)
					(12
						(EcoNarrator init: 3 0 0 47 0 5)
					)
					(else 
						(EcoNarrator init: 1 0 0 91 0 3)
					)
				)
			)
			(4
				(switch cel
					(11
						(EcoNarrator init: 3 0 0 16 0 5)
					)
					(12
						(EcoNarrator init: 3 0 0 18 0 5)
					)
					(else 
						(EcoNarrator init: 1 0 0 92 0 3)
					)
				)
			)
			(else 
				(if (and (== cel 12) (!= theVerb 38))
					(EcoNarrator init: 3 0 0 19 0 5)
				else
					(switch theVerb
						(39
							(if (== (float cel?) 10)
								(EcoNarrator init: 2 0 2 27 0 4)
							else
								(EcoNarrator init: 1 0 1 14 0 3)
							)
							(Inv hide:)
							(gEgo put: 30)
							(proc0_4 5 331)
							(if (== (float cel?) 10)
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel
															(= cel
																(= cel
																	(= cel
																		(= cel (= cel (= cel (= cel (= cel (= cel 11))))))
																	)
																)
															)
														)
													)
												)
											)
										)
									)
								)
							else
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel
															(= cel
																(= cel
																	(= cel
																		(= cel (= cel (= cel (= cel (= cel (= cel 12))))))
																	)
																)
															)
														)
													)
												)
											)
										)
									)
								)
							)
							(Inv showSelf: gEgo)
						)
						(38
							(if (== cel 12)
								(EcoNarrator init: 3 0 0 10 0 5)
								(Inv hide:)
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel
															(= cel
																(= cel
																	(= cel
																		(= cel (= cel (= cel (= cel (= cel (= cel 11))))))
																	)
																)
															)
														)
													)
												)
											)
										)
									)
								)
								(proc0_4 5 330)
								(gEgo put: 29)
								(Inv showSelf: gEgo)
							else
								(EcoNarrator init: 1 0 0 49 0 3)
							)
						)
						(37
							(EcoNarrator init: 2 0 0 3 0 4)
						)
						(else 
							(super doVerb: theVerb &rest)
						)
					)
				)
			)
		)
	)
)

(instance float of RInvItem
	(properties
		loop 6
		cel 6
		message 39
		owner 500
		cursorLoop 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(if (== cel 10)
					(EcoNarrator init: 3 0 0 2 0 5)
				else
					(EcoNarrator init: 1 0 0 93 0 3)
				)
			)
			(4
				(if (== cel 10)
					(EcoNarrator init: 3 0 0 17 0 5)
				else
					(EcoNarrator init: 1 0 0 94 0 3)
				)
			)
			(40
				(if (== cel 10)
					(EcoNarrator init: 2 0 2 27 0 4)
					(steelCable cel: 11)
				else
					(steelCable cel: 12)
					(EcoNarrator init: 1 0 1 14 0 3)
				)
				(Inv highlightedIcon: steelCable hide:)
				(gEgo put: 30)
				(proc0_4 5 331)
				(Inv showSelf: gEgo)
			)
			(38
				(EcoNarrator init: 1 0 1 16 0 3)
				(Inv hide:)
				(= cel
					(= cel
						(= cel
							(= cel
								(= cel
									(= cel
										(= cel
											(= cel
												(= cel
													(= cel
														(= cel (= cel (= cel (= cel (= cel (= cel 10))))))
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
				(proc0_4 5 330)
				(gEgo put: 29)
				(Inv showSelf: gEgo)
			)
			(else 
				(if (== (float cel?) 6)
					(EcoNarrator init: 3 0 0 3 0 5)
				else
					(EcoNarrator init: 1 0 0 53 0 3)
				)
			)
		)
	)
)

(instance sawFishHead of RInvItem
	(properties
		loop 6
		cel 8
		message 35
		owner 343
		cursorLoop 2
		cursorCel 1
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator store: 98 init: 97 0 3)
			)
			(4
				(EcoNarrator init: 1 0 0 99 0 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fishLure of RInvItem
	(properties
		loop 8
		cel 10
		message 36
		owner 343
		cursorLoop 1
		cursorCel 12
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 3 0 0 1 0 4)
			)
			(4
				(EcoNarrator init: 2 0 0 1 0 4)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hackSaw of RInvItem
	(properties
		loop 6
		cel 9
		message 37
		owner 500
		cursorLoop 2
		cursorCel 5
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 2 0 0 2 0 4)
			)
			(4
				(EcoNarrator init: 2 0 0 4 0 4)
			)
			(43
				(EcoNarrator init: 3 0 0 8 0 5)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sixPackRing of RInvItem
	(properties
		loop 8
		cel 5
		message 43
		cursorLoop 2
		cursorCel 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 2 0 2 18 0 4)
			)
			(4
				(EcoNarrator init: 2 0 2 19 0 4)
			)
			(17
				(EcoNarrator init: 2 0 2 20 0 4)
				(proc0_4 5 289)
				(Inv highlightedIcon: sharpShell hide:)
				(gEgo put: 34)
				(gInv showSelf: gEgo)
			)
			(37
				(EcoNarrator init: 3 0 0 8 0 5)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance transmitter of RInvItem
	(properties
		loop 2
		cel 2
		message 38
		owner 400
		cursorCel 7
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 2 0 0 5 0 4)
			)
			(4
				(EcoNarrator init: 2 0 0 6 0 4)
			)
			(40
				(if (== (steelCable cel?) 12)
					(EcoNarrator init: 3 0 0 10 0 5)
					(Inv highlightedIcon: steelCable hide:)
					(steelCable cel: 11)
					(proc0_4 5 330)
					(gEgo put: 29)
					(Inv showSelf: gEgo)
				else
					(EcoNarrator init: 1 0 0 49 0 3)
				)
			)
			(39
				(EcoNarrator init: 1 0 1 16 0 3)
				(Inv highlightedIcon: steelCable hide:)
				(float cel: 10)
				(proc0_4 5 330)
				(gEgo put: 29)
				(Inv showSelf: gEgo)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll of RInvItem
	(properties
		loop 8
		cel 7
		message 34
		owner 140
		cursorLoop 2
		cursorCel 3
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(cond 
					((or (== gNumber 345) (global2 script?)) (EcoNarrator init: 1 0 0 64 0 3))
					((proc804_1 370)
						(if (== gNumber 540) (PalVary pvUNINIT))
						(Inv hide:)
						(global2 setScript: (ScriptID 816 0))
					)
					(else (EcoNarrator init: 1 0 0 64 0 3))
				)
			)
			(4
				(EcoNarrator init: 3 0 0 11 0 5)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waterBottle of RInvItem
	(properties
		loop 8
		cel 9
		message 23
		owner 620
		cursorCel 6
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(EcoNarrator init: 2 0 0 12 0 4)
			)
			(4
				(EcoNarrator init: 2 0 0 13 0 4)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ok of EcoIconItem
	(properties
		view 951
		loop 4
		cel 0
		nsLeft 40
		signal $0043
		noun 1
		helpVerb 55
		helpStr 11
	)
	
	(method (init)
		(self
			cursor: (ScriptID 0 8)
			highlightColor: 0
			lowlightColor: global216
		)
		(super init:)
	)
)

(instance invLook of EcoIconItem
	(properties
		view 951
		loop 0
		cel 0
		message 1
		noun 1
		helpVerb 56
		helpStr 12
	)
	
	(method (init)
		(self
			cursor: (ScriptID 0 9)
			highlightColor: 0
			lowlightColor: global216
		)
		(super init:)
	)
)

(instance invHand of EcoIconItem
	(properties
		view 951
		loop 1
		cel 0
		message 4
		noun 1
		helpVerb 57
		helpStr 13
	)
	
	(method (init)
		(self
			cursor: (ScriptID 0 11)
			highlightColor: 0
			lowlightColor: global216
		)
		(super init:)
	)
)

(instance invHelp of EcoIconItem
	(properties
		view 951
		loop 3
		cel 0
		message 8
		noun 1
		helpVerb 54
	)
	
	(method (init)
		(self
			cursor: (ScriptID 0 10)
			highlightColor: 0
			lowlightColor: global216
		)
		(super init:)
	)
)

(instance invSelect of EcoIconItem
	(properties
		view 951
		loop 2
		cel 0
		noun 1
		helpVerb 58
		helpStr 14
	)
	
	(method (init)
		(self
			cursor: (ScriptID 0 8)
			highlightColor: 0
			lowlightColor: global216
		)
		(super init:)
	)
)

(instance invWin of InsetWindow
	(properties
		priority -1
		topBordHgt 28
		botBordHgt 5
	)
	
	(method (dispose)
		(EcoNarrator inInv: 0)
		(super dispose:)
	)
	
	(method (open &tmp temp0 gInvFirst temp2 temp3)
		(EcoNarrator inInv: 1)
		(= temp0 0)
		(= gInvFirst (gInv first:))
		(while gInvFirst
			(if
			(not ((= temp2 (NodeValue gInvFirst)) isKindOf: InvI))
				(= temp0
					(+
						temp0
						(CelWide (temp2 view?) (temp2 loop?) (temp2 cel?))
					)
				)
			)
			(= gInvFirst (gInv next: gInvFirst))
		)
		(super open:)
		(= left (= left (= left (= left 73))))
		(invLook nsLeft: (/ (- (- right left) temp0) 2))
	)
)
